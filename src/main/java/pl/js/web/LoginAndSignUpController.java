package pl.js.web;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@SessionAttributes({ "class", "tutor", "student" })
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
		if (session.getAttribute("tutor") != null) {
			Tutor tutorSess = (Tutor) session.getAttribute("tutor");
			Tutor tutor = tutorRepository.findByEmail(tutorSess.getEmail());
			tutorRepository.setTutorStatusById("offline", tutor.getId());
			return "security/logout";
		} else {
			Student studentSess = (Student) session.getAttribute("student");
			Student student = studentRepository.findByEmail(studentSess.getEmail());
			studentRepository.setStudentStatusById("offline", student.getId());
			return "security/logout";
		}
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
			session.setAttribute("tutor", tutor);
			session.setAttribute("class", tutor.getClassroom());
			if ((BCrypt.checkpw(password, tutor.getPassword()) && "ROLE_TUTOR".equals(tutor.getRole().getRole()))) {
				tutorRepository.setTutorStatusById("online", tutor.getId());
				return "redirect:/dashboard";
			} else {
				return "errors/loginPasswordError";
			}
		} catch (NullPointerException e) {
			return "errors/loginEmailError";
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
			session.setAttribute("student", student);
			session.setAttribute("class", student.getClassroom());
			if ((BCrypt.checkpw(password, student.getPassword())
					&& "ROLE_STUDENT".equals(student.getRole().getRole()))) {
				studentRepository.setStudentStatusById("online", student.getId());
				return "success " + password + " " + student.getPassword();
			} else {
				BCrypt.checkpw(password, student.getPassword());
				return student.getPassword() + password + 	BCrypt.checkpw(password, student.getPassword());
				/*return "errors/loginPasswordError";*/
			}
		} catch (NullPointerException e) {
			return "errors/loginEmailError";
		}

	}

	@GetMapping("/signup")
	public String signUp(HttpSession session, Model model) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
			Classroom classroom = classroomRepository.findAById(id);
			model.addAttribute("class", classroom);
			model.addAttribute("tutor", new Tutor());
			return "security/signUpPage";
		} catch (NullPointerException e) {
			return "errors/getClassroomError";

		}

	}

	@PostMapping("/signup")
	public String createTutor(@Validated @ModelAttribute Tutor tutor, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "security/signUpPage";
		} else {
			model.addAttribute("tutor", tutor);
			session.setAttribute("tutor", tutor);
			Classroom classroom;
			try {
				classroom = (Classroom) session.getAttribute("class");
				tutor.setClassroom(classroom);
				tutorService.save(tutor);
			} catch (NullPointerException e) {
				return "errors/getClassroomError";
			} catch (Exception e) {
				return "errors/nonUniqueTutorNameOrEmail";
			}
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/classroom")
	public String classroom(Model model) {
		model.addAttribute("classroom", new Classroom());
		return "createClassroom";
	}

	@PostMapping("/classroom")
	public String createClassroom(@Validated @ModelAttribute Classroom classroom, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "createClassroom";
		} else {
			try {
				session.setAttribute("class", classroom);
				model.addAttribute("class", classroom);
				classroomRepository.save(classroom);
			} catch (Exception e) {
				return "errors/nonUniqueName";
			}
			return "redirect:/signup";
		}

	}
}
