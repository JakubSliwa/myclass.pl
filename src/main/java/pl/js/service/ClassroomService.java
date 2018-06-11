package pl.js.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import pl.js.entity.Classroom;

@Service
public class ClassroomService {
	public Long getClassroomId(HttpSession session) {
		Classroom classroom = (Classroom) session.getAttribute("class");
		Long id = classroom.getId();
		return id;
	}
}
