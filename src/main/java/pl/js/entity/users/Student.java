package pl.js.entity.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.js.entity.exercise.BasicExercise;
import pl.js.entity.exercise.BasicSolution;

@Entity
@Table(name = "students")

public class Student extends User {

	@OneToMany
	private List<BasicSolution> basicSolution;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
	private List<BasicExercise> basicExercises;
	@Column(precision = 6, scale = 2)
	private Double avgGrade;

	public Student() {
		super();

	}

	public Double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(Double avgGrade) {
		this.avgGrade = avgGrade;
	}

	public List<BasicSolution> getBasicSolution() {
		return basicSolution;
	}

	public void setBasicSolution(List<BasicSolution> basicSolution) {
		this.basicSolution = basicSolution;
	}

	public List<BasicExercise> getBasicExercises() {
		return basicExercises;
	}

	public void setBasicExercises(List<BasicExercise> basicExercises) {
		this.basicExercises = basicExercises;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((avgGrade == null) ? 0 : avgGrade.hashCode());
		result = prime * result + ((basicExercises == null) ? 0 : basicExercises.hashCode());
		result = prime * result + ((basicSolution == null) ? 0 : basicSolution.hashCode());
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
		if (avgGrade == null) {
			if (other.avgGrade != null)
				return false;
		} else if (!avgGrade.equals(other.avgGrade))
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
		return true;
	}

}