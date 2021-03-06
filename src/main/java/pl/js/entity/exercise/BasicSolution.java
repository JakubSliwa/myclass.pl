package pl.js.entity.exercise;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.js.entity.Classroom;
import pl.js.entity.users.Student;

@Entity
@Table(name = "basicSolutions")

public class BasicSolution extends Solution {

	@ManyToOne
	private BasicExercise basicExercise;

	@ManyToOne
	private Classroom classroom;

	private LocalDate added;

	@ManyToOne
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public LocalDate getAdded() {
		return added;
	}

	public void setAdded(LocalDate added) {
		this.added = LocalDate.now();
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public BasicExercise getBasicExercise() {
		return basicExercise;
	}

	public void setBasicExercise(BasicExercise basicExercise) {
		this.basicExercise = basicExercise;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((added == null) ? 0 : added.hashCode());
		result = prime * result + ((basicExercise == null) ? 0 : basicExercise.hashCode());
		result = prime * result + ((classroom == null) ? 0 : classroom.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicSolution other = (BasicSolution) obj;
		if (added == null) {
			if (other.added != null)
				return false;
		} else if (!added.equals(other.added))
			return false;
		if (basicExercise == null) {
			if (other.basicExercise != null)
				return false;
		} else if (!basicExercise.equals(other.basicExercise))
			return false;
		if (classroom == null) {
			if (other.classroom != null)
				return false;
		} else if (!classroom.equals(other.classroom))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BasicSolution [basicExercise=" + basicExercise + ", classroom=" + classroom + ", added=" + added
				+ ", getId()=" + getId() + ", getGrade()=" + getGrade() + "]";
	}
}
