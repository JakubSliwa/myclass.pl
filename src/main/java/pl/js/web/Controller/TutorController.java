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
import pl.js.repository.BasicSolutionRepository;
import pl.js.repository.ClassroomRepository;
import pl.js.repository.StudentRepository;
import pl.js.service.BasicSolutionService;
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
	@Autowired
	BasicSolutionService basicSolutionService;
	@Autowired
	BasicSolutionRepository basicSolutionRepository;

	@GetMapping("/checksolutions")
	public String checkSolutions(Model model, HttpSession session) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		model.addAttribute("solutions", basicSolutionService.getBasicSolutionListByClassroomId(id));
		model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
		return "tutorViews/checkSolutionList";
	}

	@GetMapping("/addgrade/{solutionId}")
	public String addGrade(Model model, HttpSession session, @PathVariable(value = "solutionId") Long solutionId) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		BasicSolution basicSolution = basicSolutionRepository.findOne(solutionId);
		model.addAttribute("basicSolution", basicSolution);
		return "tutorViews/addGradeForSolutions";

	}

	@PostMapping("/addgrade/{solutionId}")
	public String addNewGrade(@Validated @ModelAttribute BasicSolution basicSolution, BindingResult result,
			@RequestParam Double grade, Model model, @PathVariable(value = "solutionId") Long solutionId) {
		if (result.hasErrors()) {
			basicSolution = basicSolutionRepository.findOne(solutionId);
			model.addAttribute("basicSolution", basicSolution);
			return "tutorViews/addGradeForSolutions";
		} else {
			basicSolutionRepository.setBasicSolutionGradeById(grade, solutionId);
			return "redirect:/dashboard";
		}
	}

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

	@GetMapping("/invitestudent")
	public String showViewToAddNewStudent(HttpSession session, Model model) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
			model.addAttribute("student", new Student());
			return "tutorViews/addNewUser";
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}

	}

	@PostMapping("/invitestudent")
	public String addNewStudent(@Validated @ModelAttribute Student student, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
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

	@GetMapping("/createexercise")
	public String showViewToAddNewExercise(Model model, HttpSession session) {
		Long id;
		try {
			id = classroomService.getClassroomId(session);
			model.addAttribute("basicExercise", new BasicExercise());
			model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
			return "tutorViews/addNewBasicExercise";
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}

	}

	@PostMapping("/createexercise")
	public String addNewExercise(@Validated @ModelAttribute BasicExercise basicExercise, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "tutorViews/addNewBasicExercise";
		} else {
			tutorService.addNewBasicExercise(basicExercise, session);
			return "redirect:/dashboard";
		}
	}

}
