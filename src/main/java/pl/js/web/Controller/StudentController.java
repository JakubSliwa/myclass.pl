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
public class StudentController {
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

	@GetMapping("/students/{studentId}")
	public String showStudent(Model model, HttpSession session, @PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		Student student;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			student = studentRepository.findOne(studentId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				studentService.updateAvgG(tutorService.getStudentListByClassroomId(id));
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("studentForView", student);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/showStudent";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/invitestudent")
	public String showViewToAddNewStudent(HttpSession session, Model model) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("student", new Student());
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/addNewUser";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/invitestudent")
	public String addNewStudent(@Validated @ModelAttribute Student student, BindingResult result, Model model,
			HttpSession session) {
		Long id;
		if (result.hasErrors()) {
			id = classroomService.getClassroomId(session);
			model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
			model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
			return "tutorViews/addNewUser";
		} else {
			try {
				tutorService.addNewStudent(student, session);
			} catch (Exception e) {
				return "errors/nonUniqueStudentNameOrEmail";
			}
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/deletestudents/{studentId}")
	public String deleteStudents(Model model, HttpSession session, @PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		Student student;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			student = studentRepository.findOne(studentId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				basicExerciseService.basicExerciseSetNullForStudentId(studentId);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "redirect:/students";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/editstudents/{studentId}")
	public String editStudents(Model model, HttpSession session, @PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		Student student;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			student = studentRepository.findOne(studentId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("student", student);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/editStudents";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/editstudents/{studentId}")
	public String editStudents(@Validated @ModelAttribute Student student, BindingResult result,
			@RequestParam String username, @RequestParam String email, Model model,
			@PathVariable(value = "studentId") Long studentId, HttpSession session) {
		Long id;
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				return "tutorViews/editStudents";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				studentRepository.setStudentLoginAndEmailById(username, email, studentId);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		}
		return "redirect:/students";
	}

	@GetMapping("/students")
	public String showStudents(Model model, HttpSession session) {
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
				return "tutorViews/studentsList";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}
}
