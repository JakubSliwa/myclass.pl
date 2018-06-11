package pl.js.web.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;
import pl.js.repository.ClassroomRepository;
import pl.js.repository.StudentRepository;
import pl.js.service.ClassroomService;
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
	StudentRepository studentRepository;
	@Autowired
	ClassroomRepository classroomRepository;
	@Autowired
	ClassroomService classroomService;

	@GetMapping("/dashboard")
	public String showTutorDashboard(Model model, HttpSession session) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
		} catch (NullPointerException e) {
			return "errors/nullPointerError";

		}

		model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
		model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
		return "tutorViews/tutorPanel";
	}

	@PostMapping("/dashboard")
	@ResponseBody
	public String addNewExcercise(HttpSession session, Model model) {
		return "tutorViews/tutorPanel";
	}

	@GetMapping("/invitestudent")
	public String showViewToAddNewStudent(HttpSession session, Model model) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
		} catch (NullPointerException e) {
			return "errors/nullPointerError";

		}
		model.addAttribute("students", new Student());
		return "tutorViews/addNewUser";
	}

	@PostMapping("/invitestudent")
	public String addNewStudent(@ModelAttribute Student student, HttpSession session) {
		tutorService.addNewStudent(student, session);
		return "redirect:/dashboard";
	}

	@GetMapping("/createexercise")
	public String showViewToAddNewExercise(Model model, HttpSession session) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
		} catch (NullPointerException e) {
			return "errors/nullPointerError";

		}
		model.addAttribute("basicExercises", new BasicExercise());
		model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
		return "tutorViews/addNewBasicExercise";
	}

	@PostMapping("/createexercise")
	public String addNewExercise(@ModelAttribute BasicExercise basicExercise, HttpSession session) {
		tutorService.addNewBasicExercise(basicExercise, session);
		return "redirect:/dashboard";
	}

}
