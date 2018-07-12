package pl.js.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.js.entity.Classroom;

@Service
public class ClassroomService {
	public Long getClassroomId(HttpSession session) {
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		Long id = classroom.getId();
		return id;
	}
}
