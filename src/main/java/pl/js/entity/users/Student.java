package pl.js.entity.users;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.js.entity.Classroom;
import pl.js.entity.exercise.AdvancedExercise;
import pl.js.entity.exercise.AdvancedSolution;
import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.exercise.BasicSolution;


@Entity
@Table(name = "students")

public class Student extends User {

	public Student(String login, String password) {
		super(login, password);
	}

	private double grade;

	public Student() {

	}

	@ManyToOne
	Classroom classroom;
	@OneToMany
	List<BasicSolution> basicSolution;;
	@OneToMany
	List<AdvancedSolution> advancedSolution;;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
	List<BasicExercise> basicExercises;

	@OneToMany
	List<AdvancedExercise> advancedExercises;;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((advancedExercises == null) ? 0 : advancedExercises.hashCode());
		result = prime * result + ((advancedSolution == null) ? 0 : advancedSolution.hashCode());
		result = prime * result + ((basicExercises == null) ? 0 : basicExercises.hashCode());
		result = prime * result + ((basicSolution == null) ? 0 : basicSolution.hashCode());
		result = prime * result + ((classroom == null) ? 0 : classroom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(grade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Student other = (Student) obj;
		if (advancedExercises == null) {
			if (other.advancedExercises != null)
				return false;
		} else if (!advancedExercises.equals(other.advancedExercises))
			return false;
		if (advancedSolution == null) {
			if (other.advancedSolution != null)
				return false;
		} else if (!advancedSolution.equals(other.advancedSolution))
			return false;
		if (basicExercises == null) {
			if (other.basicExercises != null)
				return false;
		} else if (!basicExercises.equals(other.basicExercises))
			return false;
		if (basicSolution == null) {
			if (other.basicSolution != null)
				return false;
		} else if (!basicSolution.equals(other.basicSolution))
			return false;
		if (classroom == null) {
			if (other.classroom != null)
				return false;
		} else if (!classroom.equals(other.classroom))
			return false;
		if (Double.doubleToLongBits(grade) != Double.doubleToLongBits(other.grade))
			return false;
		return true;
	}

	public List<BasicExercise> getBasicExercises() {
		return basicExercises;
	}

	public void setBasicExercises(List<BasicExercise> basicExercises) {
		this.basicExercises = basicExercises;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public List<BasicSolution> getBasicSolution() {
		return basicSolution;
	}

	public void setBasicSolution(List<BasicSolution> basicSolution) {
		this.basicSolution = basicSolution;
	}

	public List<AdvancedSolution> getAdvancedSolution() {
		return advancedSolution;
	}

	public void setAdvancedSolution(List<AdvancedSolution> advancedSolution) {
		this.advancedSolution = advancedSolution;
	}

	public List<AdvancedExercise> getAdvancedExercises() {
		return advancedExercises;
	}

	public void setAdvancedExercises(List<AdvancedExercise> advancedExercises) {
		this.advancedExercises = advancedExercises;
	}

}
