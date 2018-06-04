package pl.js.web.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;
import pl.js.service.StudentService;
import pl.js.service.TutorService;

@Controller
public class TutorController {
	@Autowired
	TutorService tutorService;

	@Autowired
	StudentService studentService;

	public TutorController(TutorService tutorService, StudentService studentService) {
		this.tutorService = tutorService;
		this.studentService = studentService;
	}

	@GetMapping("/dashboard")
	public String showTutorDashboard(Model model) {
		model.addAttribute("students", tutorService.getStudentList());
		model.addAttribute("basicExercises", tutorService.getBasicExerciseList());
		return "tutorViews/tutorPanel";
	}

	@PostMapping("/dashboard")
	@ResponseBody
	public String addNewExcercise(HttpSession session, Model model) {
		return "tutorViews/tutorPanel";
	}

	@GetMapping("/invitestudent")
	public String showViewToAddNewStudent(Model model) {
		model.addAttribute("students", new Student());
		return "tutorViews/addNewUser";
	}

	@PostMapping("/invitestudent")
	public String addNewStudent(@ModelAttribute Student student, HttpSession session) {
		tutorService.addNewStudent(student, session);
		return "redirect:/dashboard";
	}

	@GetMapping("/createexercise")
	public String showViewToAddNewExercise(Model model) {
		model.addAttribute("basicExercises", new BasicExercise());
		model.addAttribute("students", tutorService.getStudentList());
		return "tutorViews/addNewBasicExercise";
	}

	@PostMapping("/createexercise")
	public String addNewExercise(@ModelAttribute BasicExercise basicExercise) {

		tutorService.addNewBasicExercise(basicExercise);
		return "redirect:/dashboard";
	}

}
