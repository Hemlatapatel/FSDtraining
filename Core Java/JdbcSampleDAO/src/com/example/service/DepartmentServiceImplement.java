package com.example.service;

import com.example.dao.DepartmentDAOImplement;
import com.example.model.Department;

public class DepartmentServiceImplement implements DepartmentService {
	
	private DepartmentDAOImplement ddimpl = null;
	public DepartmentServiceImplement() {
		super();
		ddimpl = new DepartmentDAOImplement();
	}

	public void createDepartment(Department department) {
		// TODO Auto-generated method stub
		ddimpl.createDepartment(department);
	}
	
	public void getDepartment() {
		ddimpl.getDepartment();
	}
}
