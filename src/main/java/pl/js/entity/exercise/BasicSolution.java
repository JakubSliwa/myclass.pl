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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((basicExercise == null) ? 0 : basicExercise.hashCode());
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
		if (basicExercise == null) {
			if (other.basicExercise != null)
				return false;
		} else if (!basicExercise.equals(other.basicExercise))
			return false;
		return true;
	}
}
