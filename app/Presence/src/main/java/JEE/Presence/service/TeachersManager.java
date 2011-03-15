package JEE.Presence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import JEE.Presence.domain.Teacher;

@Stateless
public class TeachersManager {

	
	@PersistenceContext
	EntityManager em;
	
	public List<Teacher> getAllTeachers() {		
		return em.createNamedQuery("teachers.all").getResultList();
	}
	
	public void addTeacher(String name, String surname, String login, String password){
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setSurname(surname);
		teacher.setLogin(login);
		teacher.setPassword(password);
		em.persist(teacher);
	}
	public void remove(long id){
		em.createQuery("UPDATE Teacher a SET a.teacher_id ='2' WHERE a.teacher_id ='"+ id +"'").executeUpdate();
		Teacher teacher = em.find(Teacher.class, id);
		em.remove(teacher);
		
	}
}
