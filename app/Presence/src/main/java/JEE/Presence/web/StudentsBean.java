package JEE.Presence.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import JEE.Presence.domain.*;
import JEE.Presence.service.*;


@SessionScoped
@Named
public class StudentsBean implements Serializable {

	
	@Inject
	StudentsManager studentsManager;

	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String login;	
	private String password;



	private Student student = new Student();
	private DataModel<Student> allStudents = new ListDataModel<Student>();
	
	public List<Student> getAllStudents(){
		return studentsManager.getAllStudents();
}

	public StudentsManager getStudentsManager() {
		return studentsManager;
	}

	public void setStudentsManager(StudentsManager studentsManager) {
		this.studentsManager = studentsManager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	public void setAllStudents(DataModel<Student> allStudents) {
		this.allStudents = allStudents;
	}
	
	public String showStudent() { 
		this.student.setName(allStudents.getRowData().getName());
		this.student.setSurname(allStudents.getRowData().getSurname());
		this.student.setLogin(allStudents.getRowData().getLogin());
		this.student.setPassword(allStudents.getRowData().getPassword());
		
		
		return "showStudent";
	}
	
	public String addStudent() {		
		studentsManager.addStudent(name, surname, login, password);
		return "showStudent";
	}
	
	public String removeStudent() {
		// id
	student = allStudents.getRowData();
		studentsManager.remove(student.getId());
		return "showStudent";
	}
}
