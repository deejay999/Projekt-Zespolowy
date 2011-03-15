package JEE.Presence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;





import JEE.Presence.domain.Student;


@Stateless
public class StudentsManager {

	@PersistenceContext
	EntityManager em;
	
	public List<Student> getAllStudents() {		
		return em.createNamedQuery("students.all").getResultList();
	}
	
	public void addStudent(String name, String surname, String login, String password){
		Student student = new Student();
		student.setName(name);
		student.setSurname(surname);
		student.setLogin(login);
		student.setPassword(password);
		em.persist(student);
	}
	public void remove(long id){
		em.createQuery("UPDATE Student a SET a.student_id ='2' WHERE a.student_id ='"+ id +"'").executeUpdate();
		Student student = em.find(Student.class, id);
		em.remove(student);
		
	}
}
