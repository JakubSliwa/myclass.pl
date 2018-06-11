package pl.js.web.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.js.dao.ClassroomDao;
import pl.js.dao.StudentDao;
import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;
import pl.js.service.StudentService;
import pl.js.service.TutorService;

@Controller
@SessionAttributes({ "class" })
public class TutorController {
	@Autowired
	TutorService tutorService;
	@Autowired
	StudentService studentService;
	@Autowired
	StudentDao studentDao;
	@Autowired
	ClassroomDao classroomDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

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
	public String showViewToAddNewStudent(HttpSession session, Model model) {

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
