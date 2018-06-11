package pl.js.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.js.entity.Role;
import pl.js.entity.users.Student;
import pl.js.repository.RoleRepository;
import pl.js.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Student findStudentByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	public void save(Student student) {
		student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		student.setActive(1);
		Role studentRole = roleRepository.findByRole("STUDENT");
		student.setRoles(new HashSet<Role>(Arrays.asList(studentRole)));
		studentRepository.save(student);
	}

}
