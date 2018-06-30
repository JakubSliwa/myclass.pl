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

import pl.js.entity.Message;
import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.repository.BasicExerciseRepository;
import pl.js.repository.MessageRepository;
import pl.js.repository.StudentRepository;
import pl.js.service.BasicSolutionService;
import pl.js.service.ClassroomService;
import pl.js.service.MessageService;
import pl.js.service.TutorService;

@Controller
@SessionAttributes({ "class", "	tutor", "messages" })
public class MessageController {
	@Autowired
	ClassroomService classroomService;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TutorService tutorService;
	@Autowired
	MessageService messageService;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	BasicSolutionService basicSolutionService;
	@Autowired
	BasicExerciseRepository basicExerciseRepository;

	@GetMapping("/messages")
	public String messages(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("message", messageRepository.findAllBySendToTutor(tutor));
				return "tutorViews/messages";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/messages/{studentId}")
	public String AllMessagesFromStudent(Model model, HttpSession session,
			@PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		Student student;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			student = studentRepository.findOne(studentId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("message",
						messageRepository
								.findAllBySendToTutorAndSendByStudentOrSendByTutorAndSendToStudentOrderBySentDesc(
										student, tutor));
				return "tutorViews/messagesHistory";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/deletemessages/{messageId}")
	public String deleteMessages(Model model, HttpSession session, @PathVariable(value = "messageId") Long messageId) {
		Long id;
		Tutor tutor;
		Message message;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			message = messageRepository.findOne(messageId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				messageRepository.delete(message);
				return "redirect:/messages";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/message/{studentId}")
	public String messageToStudent(Model model, HttpSession session,
			@PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("studentForView", studentRepository.findOne(studentId));
				model.addAttribute("message", new Message());
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				return "tutorViews/sendMessageToStudent";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/message/{studentId}")
	public String messageToStudent(@Validated @ModelAttribute Message message, BindingResult result,
			@RequestParam String text, Model model, @PathVariable(value = "studentId") Long studentId,
			HttpSession session) {
		Long id;
		Student student;
		Tutor tutor;
		if (result.hasErrors()) {
			try {
				id = classroomService.getClassroomId(session);
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("studentForView", studentRepository.findOne(studentId));
				return "tutorViews/sendMessageToStudent";
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		} else {
			try {
				student = studentRepository.findOne(studentId);
				tutor = (Tutor) session.getAttribute("tutor");
				messageService.sendMessageFromTutorToStudent(message, student, tutor, text);
			} catch (Exception e) {
				return "errors/generalExeption";
			}
		}
		return "redirect:/students";
	}

	@GetMapping("/exercises/reminder/{exerciseId}")
	public String remiderExercise(Model model, HttpSession session,
			@PathVariable(value = "exerciseId") Long exerciseId) {
		Long id;
		Tutor tutor;
		BasicExercise basicExercise;
		Student student;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			basicExercise = basicExerciseRepository.findOne(exerciseId);
			student = basicExercise.getStudent();
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("basicExercise", basicExercise);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				messageService.sendReminderFromTutorToStudent(student, tutor, basicExercise);

				return "redirect:/exercises";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}
}
