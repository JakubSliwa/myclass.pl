package pl.js.web.controller;

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

import pl.js.entity.Lesson;
import pl.js.entity.users.Tutor;
import pl.js.repository.LessonRepository;
import pl.js.repository.MessageRepository;
import pl.js.service.BasicSolutionService;
import pl.js.service.ClassroomService;
import pl.js.service.LessonService;
import pl.js.service.MessageService;
import pl.js.service.TutorService;

@Controller
@SessionAttributes({ "classroom", "tutor", "messages", "dateTimeFormatter" })
public class LessonController {

	@Autowired
	ClassroomService classroomService;
	@Autowired
	MessageService messageService;
	@Autowired
	TutorService tutorService;
	@Autowired
	BasicSolutionService basicSolutionService;
	@Autowired
	LessonService lessonService;
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	MessageRepository messageRepository;

	@GetMapping("/lesson")
	public String sendLessonProposed(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				session.setAttribute("messagesLimited",
						messageRepository.findAllBySendToTutorAndNotReadedAndLimited("NotReaded", tutor));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				model.addAttribute("lesson", new Lesson());
				return "tutorViews/sendLessonProposed";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@PostMapping("/lesson")
	public String editExercise(@Validated @ModelAttribute Lesson lesson, BindingResult result,
			@RequestParam String dateString, @RequestParam String time, Model model, HttpSession session) {
		Long id;
		if (result.hasErrors()) {

			try {
				id = classroomService.getClassroomId(session);
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				return "tutorViews/sendLessonProposed";
			} catch (Exception e) {
				e.printStackTrace();
				return "errors/generalExeption";
			}
		} else {
			try {
				lessonService.sendLessonProposed(lesson, dateString, time, session);
			} catch (Exception e) {
				e.printStackTrace();
				return "errors/generalExeption";
			}
		}
		return "redirect:/lessons";
	}

	@GetMapping("/lessons")
	public String lessonsList(Model model, HttpSession session) {
		Long id;
		Tutor tutor;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole())) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				session.setAttribute("messagesLimited",
						messageRepository.findAllBySendToTutorAndNotReadedAndLimited("NotReaded", tutor));
				model.addAttribute("students", tutorService.getStudentListByClassroomId(id));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				model.addAttribute("lessons", lessonRepository.findAllByClassroomId(id));
				return "tutorViews/lessonsList";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}

	@GetMapping("/deletelesson/{lessonId}")
	public String deleteLesson(Model model, HttpSession session, @PathVariable(value = "lessonId") Long lessonId) {
		Long id;
		Tutor tutor;
		Lesson lesson;
		try {
			id = classroomService.getClassroomId(session);
			tutor = (Tutor) session.getAttribute("tutor");
			lesson = lessonRepository.findOne(lessonId);
			if ("ROLE_TUTOR".equals(tutor.getRole().getRole()) && id == lesson.getClassroom().getId()) {
				messageService.updateUnreadedMessages(tutor, session);
				session.setAttribute("unreaded", messageService.countCurrentUnreaded(tutor, session));
				session.setAttribute("messagesLimited",
						messageRepository.findAllBySendToTutorAndNotReadedAndLimited("NotReaded", tutor));
				model.addAttribute("solutions", basicSolutionService.getFirst10BasicSolutionListByClassroomId(id));
				lessonService.deleteLessonAndSendMessageToStudent(lesson, session);
				return "redirect:/lessons";
			}
		} catch (NullPointerException e) {
			return "errors/nullPointerError";
		}
		return "errors/notATutor";
	}
}
