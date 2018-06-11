package pl.js.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.js.entity.Classroom;
import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.users.Student;
import pl.js.entity.users.Tutor;
import pl.js.repository.BasicExerciseRepository;
import pl.js.repository.RoleRepository;
import pl.js.repository.StudentRepository;
import pl.js.repository.TutorRepository;

@Service
public class TutorService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	TutorRepository tutorRepository;

	@Autowired
	private BasicExerciseRepository basicExerciseRepository;
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void addNewStudent(@ModelAttribute Student student, HttpSession session) {
		Classroom classroom = (Classroom) session.getAttribute("class");
		student.setClassroom(classroom);
		studentService.save(student);
	}

	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

	public List<Student> getStudentListByClassroomId(Long id) {
		return studentRepository.findAllByClassroomId(id);
	}

	public void addNewBasicExercise(@ModelAttribute BasicExercise basicExercise, HttpSession session) {
		basicExercise.setAdded(LocalDate.now());
		basicExercise.setDeadline(basicExercise.getDaysToAdd());
		Classroom classroom = (Classroom) session.getAttribute("class");
		basicExercise.setClassroom(classroom);
		basicExerciseRepository.save(basicExercise);
	}

	public List<BasicExercise> getBasicExerciseList() {
		return basicExerciseRepository.findAll();
	}

	public List<BasicExercise> getBasicExerciseListClassroomId(Long id) {
		return basicExerciseRepository.findAllByClassroomId(id);
	}

	public void save(Tutor tutor) {
		tutor.setPassword(bCryptPasswordEncoder.encode(tutor.getPassword()));
		tutor.setRole(roleRepository.findByRole("ROLE_TUTOR"));
		tutorRepository.save(tutor);
	}

	public Tutor findTutorByEmail(String email) {
		return tutorRepository.findByEmail(email);
	}

	public Tutor findByUserName(String username) {
		return tutorRepository.findByUsername(username);
	}

}
