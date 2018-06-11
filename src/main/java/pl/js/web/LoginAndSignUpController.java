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

import pl.js.dao.ClassroomDao;
import pl.js.dao.TutorDao;
import pl.js.entity.Classroom;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.entity.users.User;
import pl.js.repository.StudentRepository;

@Controller
@SessionAttributes({ "class", "	tutor" })
public class LoginAndSignUpController {
	@Autowired
	ClassroomDao classroomDao;

	@Autowired
	TutorDao tutorDao;

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/login")
	public String login() {

		return "loginPage";
	}

	@PostMapping("/loginUser")
	@ResponseBody
	public String loginUser(@RequestParam String email, @RequestParam String password) {
		Student student = studentRepository.findByEmail(email);
		
		
		if (BCrypt.checkpw(password, student.getPassword())) {
			return "success";
		}
		return "fail";
	}

	@GetMapping("/signup")
	public String signUp(HttpSession session, Model model) {
		Classroom classroom = (Classroom) session.getAttribute("class");
		long classroomId = classroom.getId();
		Classroom classroomToView = classroomDao.findAById(classroomId);
		model.addAttribute("class", classroomToView);
		model.addAttribute("tutors", new Tutor());
		return "signUpPage";
	}

	@PostMapping("/signup")
	public String createTutor(@ModelAttribute Tutor tutor, Model model, HttpSession session) {
		model.addAttribute("tutor", tutor);
		session.setAttribute("tutor", tutor);
		Classroom classroom = (Classroom) session.getAttribute("class");
		tutor.setClassroom(classroom);
		tutorDao.save(tutor);
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
		classroomDao.save(classroom);
		return "redirect:/signup";
	}
}
