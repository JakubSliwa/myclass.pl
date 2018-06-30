package pl.js.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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
		String text = "Zostało Ci " + daysToDeadline + " dnis na wykonanie tego zadania. Nie zapomnij o nim;)";
		message.setReaded("NotReaded");
		message.setSendByTutor(tutor);
		message.setSendToStudent(student);
		message.setText(text);
		message.setSent(LocalDateTime.now());
		messageRepository.save(message);
	}

	public long countUnreaded(List<Message> unreadedMessages, List<Message> messages) {
		for (Message m : messages) {
			if ("NotReaded".equals(m.getReaded())) {
				unreadedMessages.add(m);
			}
		}
		return unreadedMessages.size();
	}

	public long countCurrentUnreaded(Tutor tutor) {
		List<Message> unreadedMessages = new ArrayList<>();
		List<Message> messages = messageRepository.findAllBySendToTutor(tutor);
		for (Message m : messages) {
			if ("NotReaded".equals(m.getReaded())) {
				unreadedMessages.add(m);
			}
		}
		return unreadedMessages.size();
	}
}
