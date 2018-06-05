package pl.js.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.js.dao.BasicExcerciseDao;
import pl.js.dao.StudentDao;
import pl.js.entity.Classroom;
import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;

@Service
public class TutorService {
	@Autowired
	StudentDao studentDao;

	@Autowired
	BasicExcerciseDao basicExcerciseDao;

	public void addNewStudent(@ModelAttribute Student student, HttpSession session) {
		Classroom classroom = (Classroom) session.getAttribute("class");
		student.setClassroom(classroom);
		studentDao.save(student);
	}

	public List<Student> getStudentList() {
		return studentDao.getAll();
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public BasicExcerciseDao getBasicExcerciseDao() {
		return basicExcerciseDao;
	}

	public void setBasicExcerciseDao(BasicExcerciseDao basicExcerciseDao) {
		this.basicExcerciseDao = basicExcerciseDao;
	}

	public void addNewBasicExercise(@ModelAttribute BasicExercise basicExercise) {
		basicExcerciseDao.save(basicExercise);
	}

	public List<BasicExercise> getBasicExerciseList() {

		return basicExcerciseDao.getAll();
	}
}
