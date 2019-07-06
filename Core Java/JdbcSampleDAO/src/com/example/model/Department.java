package com.example.model;

public class Department {

	private int deptId;
	private String deptName;
	private int empId;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Department(int deptId, String deptName, int empId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", empId=" + empId + "]";
	}
	
}
