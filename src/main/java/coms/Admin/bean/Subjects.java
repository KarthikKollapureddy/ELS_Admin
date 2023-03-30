package coms.Admin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject_info")

public class Subjects {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int subId;
	public String subName;
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public Subjects(int subId, String subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subjects(String subName) {
		super();
		this.subName = subName;
	}
	
	
	
	
	

}
