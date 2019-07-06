package com.example.model;

import java.sql.Date;

public class Employee {

	private String name;
	private String sex;
	private String jobTitle;
	private String organisation;
	private Date birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Employee(String name, String sex, String jobTitle, String organisation, Date birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.jobTitle = jobTitle;
		this.organisation = organisation;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", sex=" + sex + ", jobTitle=" + jobTitle + ", organisation=" + organisation
				+ ", birthday=" + birthday + "]";
	}

}
