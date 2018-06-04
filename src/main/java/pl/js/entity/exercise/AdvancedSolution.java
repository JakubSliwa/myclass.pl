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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((advancedExercise == null) ? 0 : advancedExercise.hashCode());
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
		AdvancedSolution other = (AdvancedSolution) obj;
		if (advancedExercise == null) {
			if (other.advancedExercise != null)
				return false;
		} else if (!advancedExercise.equals(other.advancedExercise))
			return false;
		return true;
	}
}
