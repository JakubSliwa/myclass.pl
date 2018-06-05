package pl.js.entity.exercise;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import pl.js.entity.users.Student;

@Entity
@Table(name = "basicExercises")
public class BasicExercise extends Exercise {
	@ManyToOne(fetch = FetchType.EAGER)
	Student student;
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime added;
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime deadline;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public DateTime getAdded() {
		return added;
	}

	public void setAdded(DateTime added) {
		this.added = DateTime.now();
	}

	public DateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(DateTime deadline) {
		this.deadline = DateTime.now();

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