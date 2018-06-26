package pl.js.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.js.entity.Message;
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

}
