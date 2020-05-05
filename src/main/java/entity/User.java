package entity;

import java.util.List;

public class User {
	private int uid;
	private String uname;
	private String upassword;
	private String uinterests;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public User(int uid, String uname, String upassword, String uinterests) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.uinterests = uinterests;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public User(String uname, String upassword, String uinterests) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.uinterests = uinterests;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUinterests() {
		return uinterests;
	}
	public void setUinterests(String uinterests) {
		this.uinterests = uinterests;
	}
}
