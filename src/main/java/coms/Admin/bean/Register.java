package coms.Admin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class Register {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;

	private String userName;
	private String firstName;
	private String lastName;
	private String pass;
	private int role;
	private String number;
	private Date dob;
	

	

//	public RegisterBean(String userName, String firstName, String lastName, String pass, int role) {
//		super();
//		this.userName = userName;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.pass = pass;
//		this.role = role;
//	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDob() {
		return dob;
	}
	
	
	
	
//	public RegisterUser(int userId, String userName, String firstName, String lastName, String pass, int role) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.pass = pass;
//		this.role = role;
//	}
	public Register() {
		
	}
	
	
	public Register(String userName, String firstName, String lastName, String pass, int role,String number,Date dob) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pass = pass;
		this.role = role;
		this.number = number;
		this.dob = (Date)dob.clone();
	}
	public Register(int userId, String userName, String firstName, String lastName, String pass, int role, String number,
			Date dob) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pass = pass;
		this.role = role;
		this.number = number;
		this.dob = dob;
	}
	
	
	
	
	
	
	
	
	


}
