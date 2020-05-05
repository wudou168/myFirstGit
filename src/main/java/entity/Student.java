package entity;

public class Student {

	private int sid;
	private String sno;
	private String sname;
	private String semail;
	private String sphone_number;
	private String sclass;

	public Student(int sid, String sno, String sname, String semail, String sphone_number, String sclass) {
		super();
		this.sid = sid;
		this.sno = sno;
		this.sname = sname;
		this.semail = semail;
		this.sphone_number = sphone_number;
		this.sclass = sclass;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSphone_number() {
		return sphone_number;
	}
	public void setSphone_number(String sphone_number) {
		this.sphone_number = sphone_number;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
}
