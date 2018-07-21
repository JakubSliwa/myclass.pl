package pl.js.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.repository.StudentRepository;
import pl.js.repository.TutorRepository;

@Controller
public class LogoutController {

	@Autowired
	TutorRepository tutorRepository;

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("tutor") != null) {
			Tutor tutorSess = (Tutor) session.getAttribute("tutor");
			Tutor tutor = tutorRepository.findByEmail(tutorSess.getEmail());
			tutorRepository.setTutorStatusById("offline", tutor.getId());
			session.invalidate();
			return "security/logout";
		} else {
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/student/logout")
	public String studentLogout(HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student studentSess = (Student) session.getAttribute("student");
			Student student = studentRepository.findByEmail(studentSess.getEmail());
			studentRepository.setStudentStatusById("offline", student.getId());
			session.invalidate();
			return "security/logout";
		} else {
			return "redirect:/startpage";
		}
	}

}
