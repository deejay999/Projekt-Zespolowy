package JEE.Presence.web;

import java.io.Serializable;


import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import JEE.Presence.domain.Teacher;
import JEE.Presence.service.TeachersManager;


@SessionScoped
@Named
public class TeachersBean implements Serializable {
	
	@Inject
	TeachersManager teachersManager;

	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String login;	
	private String password;



	private Teacher teacher = new Teacher();
	private DataModel<Teacher> allTeachers = new ListDataModel<Teacher>();
	
	
	
	public TeachersManager getTeachersManager() {
		return teachersManager;
	}

	public void setTeachersManager(TeachersManager teachersManager) {
		this.teachersManager = teachersManager;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public DataModel<Teacher> getAllTeachers() {
		return allTeachers;
	}

	public void setAllTeachers(DataModel<Teacher> allTeachers) {
		this.allTeachers = allTeachers;
	}

	public String showTeacher() { 
		this.teacher.setName(allTeachers.getRowData().getName());
		this.teacher.setSurname(allTeachers.getRowData().getSurname());
		this.teacher.setLogin(allTeachers.getRowData().getLogin());
		this.teacher.setPassword(allTeachers.getRowData().getPassword());
		
		
		return "showTeacher";
	}
	
	public String addTeacher() {		
		teachersManager.addTeacher(name, surname, login, password);
		return "teachers";
	}
	
	public String removeTeacher() {
		// id
	teacher = allTeachers.getRowData();
		teachersManager.remove(teacher.getId());
		return "teachers";
	}

}
