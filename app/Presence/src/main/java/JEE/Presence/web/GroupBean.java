package JEE.Presence.web;


import java.io.Serializable;
import java.util.List;

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
	
//	private Long id;
	private static final long serialVersionUID = 1L;
	
	//private List<Group> allGroups = new List<Group>();
	private DataModel<Group> allGroups = new ListDataModel<Group>();
	
	private int groupNumber;
	private String major;
	private int year;
	
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setAllGroups(DataModel<Group> allGroups) {
		this.allGroups = allGroups;
	}
	
	private Group group = new Group();

	public GroupManager getGroupManager() {
		return groupManager;
	}

	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}
	
	public List<Group> getAllGroups() {
		return groupManager.getAllGroups();
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
/*	
	private void clearForm() {
		major = "";
		year = groupNumber = 0;
		group = null;
		//id = null;
	}
*/	
	public String addGroup(){
		groupManager.addGroup(groupNumber, major, year);
		//clearForm();
		return "showGroups";
		
	}
	
	public String showGroup(){
		this.group.setGroupNumber(allGroups.getRowData().getGroupNumber());
		this.group.setMajor(allGroups.getRowData().getMajor());
		this.group.setYear(allGroups.getRowData().getYear());
		return "showGroup";
	}

}
