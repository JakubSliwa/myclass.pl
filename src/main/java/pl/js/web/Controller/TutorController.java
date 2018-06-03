package pl.js.web.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.js.service.TutorService;

@Controller
public class TutorController {
	@Autowired
	TutorService tutorService;

	@GetMapping("/dashboard")
	public String showTutorDashboard() {
		return "tutorViews/tutorPanel";
	}

	@PostMapping("/dashboard")
	@ResponseBody
	public String addNewExcercise(HttpSession session, Model model) {

		return "tutorViews/tutorPanel";
	}

}
