package pl.js.entity.users;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.js.entity.Classroom;
import pl.js.entity.exercise.AdvancedExercise;
import pl.js.entity.exercise.BasicExercise;

@Entity
@Table(name = "tutors")
public class Tutor extends User {

	public Tutor(String login, String password) {
		super(login, password);

	}
	

	public Tutor() {

	}
	

	@ManyToOne
	Classroom classroom;

	@OneToMany
	List<BasicExercise> basicExercise;

	@OneToMany
	List<AdvancedExercise> advancedExercise;

	public List<BasicExercise> getBasicExercise() {
		return basicExercise;
	}

	public void setBasicExercise(List<BasicExercise> basicExercise) {
		this.basicExercise = basicExercise;
	}

	public List<AdvancedExercise> getAdvancedExercise() {
		return advancedExercise;
	}

	public void setAdvancedExercise(List<AdvancedExercise> advancedExercise) {
		this.advancedExercise = advancedExercise;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

}
