package pl.js.entity.exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import pl.js.entity.users.Student;

@Entity
@Table(name = "basicExercises")

public class BasicExercise extends Exercise {
	@ManyToOne(fetch = FetchType.EAGER)
	Student student;

	private LocalDate added;

	private LocalDate deadline;

	private int daysToAdd;

	public int getDaysToAdd() {
		return daysToAdd;
	}

	public void setDaysToAdd(int daysToAdd) {
		this.daysToAdd = daysToAdd;
	}

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
		this.added = added;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(int daysToAdd) {
		this.deadline = LocalDate.now().plusDays(daysToAdd);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((added == null) ? 0 : added.hashCode());
		result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
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
		BasicExercise other = (BasicExercise) obj;
		if (added == null) {
			if (other.added != null)
				return false;
		} else if (!added.equals(other.added))
			return false;
		if (deadline == null) {
			if (other.deadline != null)
				return false;
		} else if (!deadline.equals(other.deadline))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

}