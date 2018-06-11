package pl.js.service;

import pl.js.entity.users.Student;

public interface StudentService {
	public Student findStudentByEmail(String email);

	public void save(Student student);

	public Student findByUserName(String username);
}
