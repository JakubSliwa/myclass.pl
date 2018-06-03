package pl.js.entity.exercise;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advancedSolutions")
public class AdvancedSolution extends Solution {
	private double grade;
	@ManyToOne
	AdvancedExercise advancedExercise;

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public AdvancedExercise getAdvancedExercise() {
		return advancedExercise;
	}

	public void setAdvancedExercise(AdvancedExercise advancedExercise) {
		this.advancedExercise = advancedExercise;
	}
}
