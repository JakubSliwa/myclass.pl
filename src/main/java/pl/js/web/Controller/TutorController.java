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
import pl.js.entity.users.Tutor;
import pl.js.repository.BasicExerciseRepository;
import pl.js.repository.BasicSolutionRepository;
import pl.js.repository.ClassroomRepository;
import pl.js.repository.StudentRepository;
import pl.js.service.BasicExerciseService;
import pl.js.service.BasicSolutionService;
import pl.js.service.ClassroomService;
import pl.js.service.StudentService;
import pl.js.service.TutorService;

@Controller
@SessionAttributes({ "class", "	tutor" })
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
	@Autowired
	BasicExerciseRepository basicExerciseRepository;
	@Autowired
	BasicExerciseService basicExerciseService;

	@GetMapping("/dashboard")
	public String showTutorDashboard(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("student", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/tutorPanel";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";

	}

	@GetMapping("/checksolutions")
	public String checkSolutions(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getBasicSolutionListByClassroomId(id));
				model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
				return "tutorViews/checkSolutionList";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/addgrade/{solutionId}")
	public String addGrade(Model model, HttpSession session, @PathVariable(value = "solutionId") Long solutionId) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				BasicSolution basicSolution = basicSolutionRepository.findOne(solutionId);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicSolution", basicSolution);
				return "tutorViews/addGradeForSolutions";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/addgrade/{solutionId}")
	public String addNewGrade(@Validated @ModelAttribute BasicSolution basicSolution, BindingResult result,
			@RequestParam Double grade, Model model, @PathVariable(value = "solutionId") Long solutionId,
			HttpSession session) {
		Long id;
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				basicSolution = basicSolutionRepository.findOne(solutionId);
				model.addAttribute("basicSolution", basicSolution);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				return "tutorViews/addGradeForSolutions";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				basicSolutionRepository.setBasicSolutionGradeById(grade, solutionId);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		}
		return "redirect:/dashboard";
	}

	@GetMapping("/deletestudents/{studentId}")
	public String deleteStudents(Model model, HttpSession session, @PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		Student student;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			student = studentRepository.findOne(studentId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				basicExerciseService.basicExerciseSetNullForStudentId(studentId);
				return "redirect:/students";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/editstudents/{studentId}")
	public String editStudents(Model model, HttpSession session, @PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		Student student;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			student = studentRepository.findOne(studentId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("student", student);
				return "tutorViews/editStudents";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/editstudents/{studentId}")
	public String editStudents(@Validated @ModelAttribute Student student, BindingResult result,
			@RequestParam String username, @RequestParam String email, Model model,
			@PathVariable(value = "studentId") Long studentId, HttpSession session) {
		Long id;
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				student = studentRepository.findOne(studentId);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("student", student);
				return "tutorViews/editStudents";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				studentRepository.setStudentLoginAndEmailById(username, email, studentId);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		}
		return "redirect:/students";
	}

	@GetMapping("/students")
	public String showStudents(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				return "tutorViews/studentsList";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/deleteexercises/{exerciseId}")
	public String deleteExercises(Model model, HttpSession session,
			@PathVariable(value = "exerciseId") Long exerciseId) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				basicSolutionService.basicSolutionSetNullForExerciseId(exerciseId);
				return "redirect:/exercises";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/exercises")
	public String showExercises(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicExercises", tutorService.getBasicExerciseListClassroomId(id));
				return "tutorViews/exercisesList";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/students/{studentId}")
	public String showStudent(Model model, HttpSession session, @PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("student", studentRepository.findOne(studentId));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				return "tutorViews/showStudent";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/invitestudent")
	public String showViewToAddNewStudent(HttpSession session, Model model) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("student", new Student());
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				return "tutorViews/addNewUser";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/invitestudent")
	public String addNewStudent(@Validated @ModelAttribute Student student, BindingResult result, Model model,
			HttpSession session) {
		Long id;
		if (result.hasErrors()) {
			id = classroomService.getClassroomId(session);
			model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
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
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("basicExercise", new BasicExercise());
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				return "tutorViews/addNewBasicExercise";
			}

		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/createexercise")
	public String addNewExercise(@Validated @ModelAttribute BasicExercise basicExercise, BindingResult result,
			HttpSession session, Model model) {
		Long id;
		if (result.hasErrors()) {
			id = classroomService.getClassroomId(session);
			model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
			return "tutorViews/addNewBasicExercise";
		} else {
			tutorService.addNewBasicExercise(basicExercise, session);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/editexercises/{exerciseId}")
	public String editExercise(Model model, HttpSession session, @PathVariable(value = "exerciseId") Long exerciseId) {
		Long id;
		Tutor tutor;
		BasicExercise basicExercise;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			basicExercise = basicExerciseRepository.findOne(exerciseId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicExercise", basicExercise);
				return "tutorViews/editExercise";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/editexercises/{exerciseId}")
	public String editExercise(@Validated @ModelAttribute BasicExercise basicExercise, BindingResult result,
			@RequestParam String title, @RequestParam String description, @RequestParam Integer daysToAdd, Model model,
			@PathVariable(value = "exerciseId") Long exerciseId, HttpSession session) {
		Long id;
		Student student = (Student) basicExercise.getStudent();
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				basicExercise = basicExerciseRepository.findOne(exerciseId);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicExercise", basicExercise);
				return "tutorViews/editExercise";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				basicExerciseService.basicExcerciseUpdate(basicExercise, title, description, daysToAdd, exerciseId,
						student);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		}
		return "redirect:/exercises";
	}

}
