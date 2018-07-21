package pl.js.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.js.entity.users.Student;
import pl.js.repository.BasicSolutionRepository;
import pl.js.repository.RoleRepository;
import pl.js.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private BasicSolutionRepository basicSolutionRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Student findStudentByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Transactional
	public void save(Student student) {
		student.setRole(roleRepository.findByRole("ROLE_STUDENT"));
		studentRepository.save(student);
	}

	public Student findByUserName(String username) {
		return studentRepository.findByUserName(username);
	}

	@Transactional
	public void updateAvgG(List<Student> students) {
		Double avgG;
		for (Student s : students) {
			avgG = basicSolutionRepository.getAvgGradeByStudentId(s);
			s.setAvgGrade(avgG);
			studentRepository.save(s);
		}
	}
}
