package JEE.Presence.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import JEE.Presence.domain.Group;

import JEE.Presence.service.GroupManager;


@SessionScoped
@Named
public class GroupBean implements Serializable{
	
	@Inject
	GroupManager groupManager;
	private DataModel<Group> allGroups = new ListDataModel<Group>();
	
	private Integer groupNumber;
	private String major;
	private Integer year;
	
	private Group group = new Group();

	public GroupManager getGroupManager() {
		return groupManager;
	}

	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}
	
	public DataModel<Group> getAllGroups() {
		return allGroups;
	}

	public void setAllGroups(DataModel<Group> allGroups) {
		this.allGroups = allGroups;
	}

	public Integer getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(Integer groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public String addGroup(){
		groupManager.addGroup(groupNumber, major, year);
		return "groups";
		
	}
	
	public String showGroup(){
		this.group.setGroupNumber(allGroups.getRowData().getGroupNumber());
		this.group.setMajor(allGroups.getRowData().getMajor());
		this.group.setYear(allGroups.getRowData().getYear());
		return "showGroup";
	}

}
