package pl.js.web;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.js.entity.Classroom;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.repository.ClassroomRepository;
import pl.js.repository.StudentRepository;
import pl.js.repository.TutorRepository;
import pl.js.service.ClassroomService;
import pl.js.service.TutorService;

@Controller
@SessionAttributes({ "class", "	tutor" })
public class LoginAndSignUpController {
	@Autowired
	ClassroomRepository classroomRepository;
	@Autowired
	ClassroomService classroomService;
	@Autowired
	TutorRepository tutorRepository;

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TutorService tutorService;

	@GetMapping("/login")
	public String login() {

		return "security/preLoginPage";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.getMaxInactiveInterval();
		return "security/logout";
	}

	@GetMapping("/loginTutor")
	public String loginTutor() {

		return "security/tutorLoginPage";
	}

	@PostMapping("/loginTutor")
	public String loginTutor(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {
		Tutor tutor;
		try {
			tutor = tutorRepository.findByEmail(email);
		} catch (Exception e) {
			return "errors/nullPointerError";
		}

		session.setAttribute("tutor", tutor);
		session.setAttribute("class", tutor.getClassroom());
		if ((BCrypt.checkpw(password, tutor.getPassword()) && "ROLE_TUTOR".equals(tutor.getRole().getRole()))) {
			return "redirect:/dashboard";
		} else {
			return "errors/loginError";
		}

	}

	@GetMapping("/loginStudent")
	public String loginStudent() {

		return "security/studentLoginPage";
	}

	@PostMapping("/loginStudent")
	@ResponseBody
	public String loginStudent(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {
		Student student;
		try {
			student = studentRepository.findByEmail(email);
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}

		session.setAttribute("student", student);
		session.setAttribute("class", student.getClassroom());
		if ((BCrypt.checkpw(password, student.getPassword()) && "ROLE_STUDENT".equals(student.getRole().getRole()))) {
			return "success " + password + " " + student.getPassword();
		} else {
			return "errors/loginError";
		}
	}

	@GetMapping("/signup")
	public String signUp(HttpSession session, Model model) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
		} catch (NullPointerException e) {
			return "errors/nullPointerError";

		}
		model.addAttribute("class", id);
		model.addAttribute("tutors", new Tutor());
		return "security/signUpPage";
	}

	@PostMapping("/signup")
	public String createTutor(@ModelAttribute Tutor tutor, Model model, HttpSession session) {
		model.addAttribute("tutor", tutor);
		session.setAttribute("tutor", tutor);
		Classroom classroom;
		try {
			classroom = (Classroom) session.getAttribute("class");
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		tutor.setClassroom(classroom);
		tutorService.save(tutor);
		return "redirect:/dashboard";
	}

	@GetMapping("/classroom")
	public String classroom(Model model) {
		model.addAttribute("classrooms", new Classroom());
		return "createClassroom";
	}

	@PostMapping("/classroom")
	public String createClassroom(@ModelAttribute Classroom classroom, Model model, HttpSession session) {
		session.setAttribute("class", classroom);
		model.addAttribute("class", classroom);
		classroomRepository.save(classroom);
		return "redirect:/signup";
	}
}
