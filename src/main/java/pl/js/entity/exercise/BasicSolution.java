package pl.js.entity.exercise;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "basicSolutions")
public class BasicSolution extends Solution {
	@ManyToOne
	BasicExercise basicExercise;

	public BasicExercise getBasicExercise() {
		return basicExercise;
	}

	public void setBasicExercise(BasicExercise basicExercise) {
		this.basicExercise = basicExercise;
	}
}
