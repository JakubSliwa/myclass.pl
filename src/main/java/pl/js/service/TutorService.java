package pl.js.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	private TutorRepository tutorRepository;

	@Autowired
	private BasicExerciseRepository basicExerciseRepository;

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public void addNewStudent(@ModelAttribute Student student, HttpSession session) {
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		student.setClassroom(classroom);
		student.setStatus("offline");
		studentService.save(student);
	}

	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

	public List<Student> getStudentListByClassroomId(Long id) {
		return studentRepository.findAllByClassroomId(id);
	}

	@Transactional
	public void addNewBasicExercise(@ModelAttribute BasicExercise basicExercise, HttpSession session) {
		basicExercise.setAdded(LocalDate.now());
		basicExercise.setDeadline(basicExercise.getDaysToAdd());
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		basicExercise.setClassroom(classroom);
		basicExerciseRepository.save(basicExercise);
	}

	public List<BasicExercise> getBasicExerciseList() {
		return basicExerciseRepository.findAll();
	}

	public List<BasicExercise> getBasicExerciseListClassroomId(Long id) {
		return basicExerciseRepository.findAllByClassroomId(id);
	}

	@Transactional
	public void save(Tutor tutor) {
		tutor.setRole(roleRepository.findByRole("ROLE_TUTOR"));
		tutorRepository.save(tutor);
	}

	public Tutor findTutorByEmail(String email) {
		return tutorRepository.findByEmail(email);
	}

	public Tutor findByUserName(String username) {
		return tutorRepository.findByUsername(username);
	}

	public Tutor findTutorById(Long id) {
		return tutorRepository.findOne(id);
	}

	@Transactional
	public void updateTutor(Tutor tutor, String username, String email, String password, HttpSession session) {
		tutor.setPassword(password);
		Long id = tutor.getId();
		tutorRepository.setTutorLoginAndEmailById(username, email, id);
		Tutor tutorAfter = tutorRepository.findOne(id);
		session.setAttribute("tutor", tutorAfter);
	}

}
