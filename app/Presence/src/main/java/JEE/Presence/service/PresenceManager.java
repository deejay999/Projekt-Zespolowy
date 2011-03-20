package JEE.Presence.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import JEE.Presence.domain.Presence;
import JEE.Presence.domain.Student;

public class PresenceManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addPresence(Student student, Date date /*Lecture lecture*/){
		Presence presence = new Presence();
		presence.setStudent(student);
		presence.setDate(date);
		//presence.setLecture(lecture);
		
		em.persist(presence);
	}

}
