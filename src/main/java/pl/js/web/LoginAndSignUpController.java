package pl.js.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.js.dao.ClassroomDao;
import pl.js.dao.TutorDao;
import pl.js.entity.Classroom;
import pl.js.entity.users.Tutor;

@Controller
@SessionAttributes({ "class", "	tutor" })
public class LoginAndSignUpController {
	@Autowired
	ClassroomDao classroomDao;

	@Autowired
	TutorDao tutorDao;

	@GetMapping("/login")
	public String login() {

		return "loginPage";
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
