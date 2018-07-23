package pl.js;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pl.js.entity.users.Student;
import pl.js.repository.StudentRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@WebAppConfiguration("src/test/resources")
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	

	@Test
	public void find_by_first_name_then_return_student() {
		Student john = new Student();
		john.setUsername("John");
		studentRepository.save(john);
		Student result = studentRepository.findByUserName("John");
		assertEquals(result.getUsername(), john.getUsername());
	}
}
