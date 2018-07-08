package pl.js.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.js.entity.Lesson;
import pl.js.repository.LessonRepository;

@Service
public class LessonService {

	@Autowired
	LessonRepository lessonRepository;

	public void sendLessonProposed(Lesson lesson, String date, String time) {
		String datetime = date + "T" + time;
		LocalDateTime localDateTime = LocalDateTime.parse(datetime);
		lesson.setDate(localDateTime);
		lesson.setAccepted(0);
		lessonRepository.save(lesson);
	}

}
