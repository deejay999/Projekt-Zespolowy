package JEE.Presence.domain;
import java.util.Date;


public class Presence {
	private Student student;
	private Date date;
	private Lecture lecture;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	

}
