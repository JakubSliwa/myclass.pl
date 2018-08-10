package pl.js;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pl.js.entity.Classroom;
import pl.js.entity.users.Student;
import pl.js.repository.ClassroomRepository;
import pl.js.repository.StudentRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@WebAppConfiguration("src/test/resources")
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassroomRepository classroomRepository;

	@Test
	public void set__student_login_and_email_by_id_return_true() {
		Student john = new Student();
		john.setId((long) 1);
		john.setUsername("tom");
		john.setEmail("ll@.pl");
		studentRepository.save(john);
		studentRepository.setStudentLoginAndEmailById("John", "john@test.pl", (long) 1);
		studentRepository.save(john);
		Student result = studentRepository.findOne((long) 1);
		assertEquals( "John",result.getUsername());
		assertEquals("john@test.pl",result.getEmail() );
	}

	@Test
	public void find_all_by_Classroom_id_then_return_student_list() {
		Classroom classroom = new Classroom();
		classroom.setId((long) 1);
		classroomRepository.save(classroom);
		Student john = new Student();
		john.setUsername("John");
		john.setClassroom(classroom);
		john.setId((long) 1);
		studentRepository.save(john);
		Student john2 = new Student();
		john2.setUsername("John2");
		john2.setClassroom(classroom);
		john2.setId((long) 2);
		studentRepository.save(john2);
		List<Student> result = studentRepository.findAllByClassroomId(classroom.getId());
		assertEquals(result.size(), 2);
	}

	@Test
	public void find_by_first_name_then_return_student() {
		Student john = new Student();
		john.setUsername("John");
		studentRepository.save(john);
		Student result = studentRepository.findByUserName("John");
		assertEquals(result.getUsername(), john.getUsername());
	}
}
