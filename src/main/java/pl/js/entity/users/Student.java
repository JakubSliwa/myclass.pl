package pl.js.entity.users;

import java.util.List;

import javax.persistence.Entity;
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
		// TODO Auto-generated constructor stub
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

	@OneToMany
	List<BasicExercise> basicExercises;;
	@OneToMany
	List<AdvancedExercise> advancedExercises;;

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

	public List<BasicExercise> getBasicExercises() {
		return basicExercises;
	}

	public void setBasicExercises(List<BasicExercise> basicExercises) {
		this.basicExercises = basicExercises;
	}

	public List<AdvancedExercise> getAdvancedExercises() {
		return advancedExercises;
	}

	public void setAdvancedExercises(List<AdvancedExercise> advancedExercises) {
		this.advancedExercises = advancedExercises;
	}

}
