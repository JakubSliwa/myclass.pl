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
public class TutorController {
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

	@GetMapping("/dashboard")
	public String showTutorDashboard(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("student", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/tutorPanel";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";

	}

	@GetMapping("/tutorsettings")
	public String tutorSettings(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("student", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("tutor", tutorService.findTutorById(tutor.getId()));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/tutorSettings";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}

		return "errors/notATutor";

	}

	@PostMapping("/tutorsettings")
	public String tutorSettings(@Validated @ModelAttribute Tutor tutor, BindingResult result,
			@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model,
			HttpSession session) {
		Long id;
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/tutorSettings";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				tutor = (Tutor) session.getAttribute("tutor");
				tutorService.updateTutor(tutor, username, email, password, session);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
			return "redirect:/tutorsettings";
		}
	}

}
