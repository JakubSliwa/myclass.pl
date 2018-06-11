package pl.js.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.js.entity.users.Student;
import pl.js.repository.RoleRepository;
import pl.js.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Student findStudentByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	public void save(Student student) {
		student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		student.setRole(roleRepository.findByRole("ROLE_STUDENT"));
		studentRepository.save(student);
	}

	public Student findByUserName(String username) {
		return studentRepository.findByUserName(username);
	}

}
