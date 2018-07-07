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
import pl.js.entity.users.Tutor;
import pl.js.repository.BasicExerciseRepository;
import pl.js.repository.BasicSolutionRepository;
import pl.js.repository.MessageRepository;
import pl.js.repository.StudentRepository;
import pl.js.service.BasicSolutionService;
import pl.js.service.ClassroomService;
import pl.js.service.MessageService;
import pl.js.service.TutorService;

@Controller
@SessionAttributes({ "class", "tutor", "messages" })
public class SolutionController {
	@Autowired
	ClassroomService classroomService;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TutorService tutorService;
	@Autowired
	MessageService messageService;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	BasicSolutionService basicSolutionService;
	@Autowired
	BasicExerciseRepository basicExerciseRepository;
	@Autowired
	BasicSolutionRepository basicSolutionRepository;

	@GetMapping("/solutions/setexercise/{solutionId}")
	public String setExercise(Model model, HttpSession session, @PathVariable(value = "solutionId") Long solutionId) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				model.addAttribute("basicSolution", basicSolutionRepository.findOne(solutionId));
				model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
				return "tutorViews/setExercise";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/solutions/setexercise/{solutionId}")
	public String setExercise(@Validated @ModelAttribute BasicSolution basicSolution, BindingResult result, Model model,
			@PathVariable(value = "solutionId") Long solutionId, HttpSession session) {
		Long id;
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/setExercise";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				basicSolutionRepository.save(basicSolution);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		}
		return "redirect:/dashboard";
	}

	@GetMapping("/addgrade/{solutionId}")
	public String addGrade(Model model, HttpSession session, @PathVariable(value = "solutionId") Long solutionId) {
		Long id;
		Tutor tutor;
		BasicSolution basicSolution;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			basicSolution = basicSolutionRepository.findOne(solutionId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicSolution", basicSolution);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/addGradeForSolutions";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/addgrade/{solutionId}")
	public String addNewGrade(@Validated @ModelAttribute BasicSolution basicSolution, BindingResult result,
			@RequestParam String grade, Model model, @PathVariable(value = "solutionId") Long solutionId,
			HttpSession session) {
		Long id;
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/addGradeForSolutions";
			} catch (NumberFormatException e) {
				return "errors/generalExeption";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				basicSolutionService.addGrade(grade, solutionId);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		}
		return "redirect:/dashboard";
	}

	@GetMapping("/checksolutions")
	public String checkSolutions(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getBasicSolutionListByClassroomId(id));
				model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
				return "tutorViews/checkSolutionList";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/deletesolutions/{solutionId}")
	public String deleteExercises(Model model, HttpSession session,
			@PathVariable(value = "solutionId") Long solutionId) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				basicSolutionRepository.delete(solutionId);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "redirect:/checksolutions";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}
}
