package JEE.Presence.service;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import JEE.Presence.domain.Group;
import JEE.Presence.domain.Teacher;


public class GroupManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addGroup(Integer groupNumber, String major, Integer year){
		Group group = new Group();
		group.setGroupNumber(groupNumber);
		group.setMajor(major);
		group.setYear(year);
		
	}
	
	public void removeGroup(long id){
		em.createQuery("UPDATE Group a SET a.group_id = '2' WHERE a.group_id = '" + id + "'").executeUpdate();
		Group group = em.find(Group.class, id);
		em.remove(group);
	}

}
