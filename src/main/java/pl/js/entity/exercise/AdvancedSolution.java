package pl.js.entity.exercise;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advancedSolutions")
public class AdvancedSolution extends Solution {
	
	@ManyToOne
	AdvancedExercise advancedExercise;

	public AdvancedExercise getAdvancedExercise() {
		return advancedExercise;
	}

	public void setAdvancedExercise(AdvancedExercise advancedExercise) {
		this.advancedExercise = advancedExercise;
	}
}
