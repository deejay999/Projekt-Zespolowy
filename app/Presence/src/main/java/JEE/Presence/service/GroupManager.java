package JEE.Presence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import JEE.Presence.domain.Group;

@Stateless
public class GroupManager {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Group> getAllGroups(){
		return em.createNamedQuery("groups.all").getResultList();
	}
	
	public void addGroup(int groupNumber, String major, int year){
		Group group = new Group();
		group.setGroupNumber(groupNumber);
		group.setMajor(major);
		group.setYear(year);
		
		em.persist(group);
		
	}
	
	public void removeGroup(long id){
		em.createQuery("UPDATE Group a SET a.group_id = '2' WHERE a.group_id = '" + id + "'").executeUpdate();
		Group group = em.find(Group.class, id);
		em.remove(group);
	}

}
