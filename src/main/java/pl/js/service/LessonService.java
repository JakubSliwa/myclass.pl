package pl.js.service;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.js.entity.Classroom;
import pl.js.entity.Lesson;
import pl.js.entity.Message;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.repository.LessonRepository;

@Service
public class LessonService {

	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	MessageService messageService;

	@Transactional
	public void sendLessonProposed(Lesson lesson, String dateString, String time, HttpSession session) {
		String[] parts = dateString.split("-");
		String dateStringCorrectFormat = parts[2] + "-" + parts[0] + "-" + parts[1];
		String datetime = dateStringCorrectFormat + "T" + time;
		LocalDateTime localDateTime = LocalDateTime.parse(datetime);
		lesson.setDate(localDateTime);
		lesson.setAccepted(0);
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		lesson.setClassroom(classroom);
		lessonRepository.save(lesson);
	}

	@Transactional
	public void deleteLessonAndSendMessageToStudent(Lesson lesson, HttpSession session) {
		Message message = new Message();
		Student student = lesson.getStudent();
		Tutor tutor = (Tutor) session.getAttribute("tutor");
		String text = "Odwołałem lekcję: " + lesson.getSubject();
		messageService.sendMessageAfterCancelLesson(message, student, tutor, text, session);
		lessonRepository.delete(lesson);
	}

}
