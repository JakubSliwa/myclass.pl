package sys_school;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.js.entity.Classroom;
import pl.js.entity.users.Student;

public class StudentTest {

	@Test
	public void testSetClassroom() {
		Student student = new Student();
		Classroom classroom = new Classroom();
		classroom.setId((long) 1);
		classroom.setName("Testowa");
		student.setClassroom(classroom);
		assertNotNull(student.getClassroom());
		assertSame(classroom.getId(), student.getClassroom().getId());
	}

}
