package pl.js.web.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.js.entity.Message;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.repository.MessageRepository;
import pl.js.repository.StudentRepository;
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

	@GetMapping("/messages")
	public String messages(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
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

	@GetMapping("/message/{studentId}")
	public String messageToStudent(Model model, HttpSession session,
			@PathVariable(value = "studentId") Long studentId) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("studentForView", studentRepository.findOne(studentId));
				model.addAttribute("message", new Message());
				return "tutorViews/sendMessageToStudent";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/message/{studentId}")
	public String editStudents(@Validated @ModelAttribute Message message, BindingResult result,
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
}
