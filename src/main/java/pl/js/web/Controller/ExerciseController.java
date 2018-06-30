package pl.js.web.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.exercise.BasicSolution;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.repository.BasicExerciseRepository;
import pl.js.repository.BasicSolutionRepository;
import pl.js.repository.ClassroomRepository;
import pl.js.repository.MessageRepository;
import pl.js.repository.StudentRepository;
import pl.js.repository.TutorRepository;
import pl.js.service.BasicExerciseService;
import pl.js.service.BasicSolutionService;
import pl.js.service.ClassroomService;
import pl.js.service.MessageService;
import pl.js.service.StudentService;
import pl.js.service.TutorService;

@Controller
@SessionAttributes({ "class", "tutor", "messages", "dateTimeFormatter" })
public class ExerciseController {
	@Autowired
	TutorService tutorService;
	@Autowired
	TutorRepository tutorRepository;
	@Autowired
	StudentService studentService;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ClassroomRepository classroomRepository;
	@Autowired
	ClassroomService classroomService;
	@Autowired
	MessageService messageService;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	BasicSolutionService basicSolutionService;
	@Autowired
	BasicSolutionRepository basicSolutionRepository;
	@Autowired
	BasicExerciseRepository basicExerciseRepository;
	@Autowired
	BasicExerciseService basicExerciseService;

	@GetMapping("/editexercises/{exerciseId}")
	public String editExercise(Model model, HttpSession session, @PathVariable(value = "exerciseId") Long exerciseId) {
		Long id;
		Tutor tutor;
		BasicExercise basicExercise;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			basicExercise = basicExerciseRepository.findOne(exerciseId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicExercise", basicExercise);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/editExercise";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/editexercises/{exerciseId}")
	public String editExercise(@Validated @ModelAttribute BasicExercise basicExercise, BindingResult result,
			@RequestParam String title, @RequestParam String description, @RequestParam Integer daysToAdd, Model model,
			@PathVariable(value = "exerciseId") Long exerciseId, HttpSession session) {
		Long id;
		Student student = (Student) basicExercise.getStudent();
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				return "tutorViews/editExercise";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				basicExerciseService.basicExcerciseUpdate(basicExercise, title, description, daysToAdd, exerciseId,
						student);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		}
		return "redirect:/exercises";
	}

	@GetMapping("/createexercise")
	public String showViewToAddNewExercise(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("basicExercise", new BasicExercise());
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/addNewBasicExercise";
			}

		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/createexercise")
	public String addNewExercise(@Validated @ModelAttribute BasicExercise basicExercise, BindingResult result,
			HttpSession session, Model model) {
		Long id;
		if (result.hasErrors()) {
			id = classroomService.getClassroomId(session);
			model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
			model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
			return "tutorViews/addNewBasicExercise";
		} else {
			tutorService.addNewBasicExercise(basicExercise, session);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/deleteexercises/{exerciseId}")
	public String deleteExercises(Model model, HttpSession session,
			@PathVariable(value = "exerciseId") Long exerciseId) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				basicSolutionService.basicSolutionSetNullForExerciseId(exerciseId);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "redirect:/exercises";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/exercises")
	public String showExercises(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/exercisesList";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

}
