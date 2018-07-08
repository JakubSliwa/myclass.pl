package pl.js.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.js.entity.Message;
import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	MessageRepository messageRepository;

	public void sendMessageFromTutorToStudent(@ModelAttribute Message message, Student student, Tutor tutor,
			String text) {
		message.setReaded("NotReaded");
		message.setSendByTutor(tutor);
		message.setSendToStudent(student);
		message.setSent(LocalDateTime.now());
		messageRepository.save(message);
	}

	public void sendReminderFromTutorToStudent(Student student, Tutor tutor, BasicExercise basicExercise) {
		Message message = new Message();
		LocalDate deadline = basicExercise.getDeadline();
		Long daysToDeadline = ChronoUnit.DAYS.between(LocalDate.now(), deadline);
		if (daysToDeadline >= 2) {
			String text = "Zostało Ci " + daysToDeadline + " dni na wykonanie zadania " + basicExercise.getTitle()
					+ ". Nie zapomnij o nim;)";
			message.setReaded("NotReaded");
			message.setSendByTutor(tutor);
			message.setSendToStudent(student);
			message.setText(text);
			message.setSent(LocalDateTime.now());
			messageRepository.save(message);
		} else if (daysToDeadline == 1) {
			String text = "Został Ci jeden dzień na wykonanie zadania " + basicExercise.getTitle()
					+ ". Nie zapomnij o nim;)";
			message.setReaded("NotReaded");
			message.setSendByTutor(tutor);
			message.setSendToStudent(student);
			message.setText(text);
			message.setSent(LocalDateTime.now());
			messageRepository.save(message);
		} else {
			String text = "Zadanie " + basicExercise.getTitle() + " powinno być już zrobione)";
			message.setReaded("NotReaded");
			message.setSendByTutor(tutor);
			message.setSendToStudent(student);
			message.setText(text);
			message.setSent(LocalDateTime.now());
			messageRepository.save(message);
		}

	}

	public long countUnreaded(List<Message> unreadedMessages, List<Message> messages) {
		for (Message m : messages) {
			if ("NotReaded".equals(m.getReaded())) {
				unreadedMessages.add(m);
			}
		}
		return unreadedMessages.size();
	}

	public void sendMessage(Message message) {
		message.setSent(LocalDateTime.now());
		message.setReaded("NotReaded");
		messageRepository.save(message);
	}

	@SuppressWarnings("unchecked")
	public long countCurrentUnreaded(Tutor tutor, HttpSession session) {
		List<Message> unreadedMessages = new ArrayList<>();
		List<Message> messages = (List<Message>) session.getAttribute("messages");
		for (Message m : messages) {
			if ("NotReaded".equals(m.getReaded())) {
				unreadedMessages.add(m);
			}
		}
		return unreadedMessages.size();
	}

	public void setToReaded(Message message) {
		message.setReaded("Readed");
		messageRepository.save(message);

	}

	@SuppressWarnings("unchecked")
	public void updateUnreadedMessages(Tutor tutor, HttpSession session) {
		List<Message> unreadedMessages = messageRepository.findAllBySendToTutorAndReaded(tutor, "NotReaded");
		List<Message> messages = (List<Message>) session.getAttribute("messages");
		messages.removeAll(messages);
		messages.addAll(unreadedMessages);
		session.setAttribute("messages", messages);
	}
}
