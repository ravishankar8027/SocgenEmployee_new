package com.societegeneral.model;

import java.io.Serializable;

public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String departmentname;
	private String departmentcode;
	public Department(String name,String code) {
		// TODO Auto-generated constructor stub
		this.setDepartmentname(name);
		this.setDepartmentcode(code);
	}
	public String getDepartmentcode() {
		return departmentcode;
	}
	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
}
