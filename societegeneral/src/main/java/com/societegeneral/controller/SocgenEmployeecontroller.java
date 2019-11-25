
/*
 Author by Ravishankar 
 */
package com.societegeneral.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.societegeneral.model.Department;
import com.societegeneral.model.SocgenEmployee;
import com.societegeneral.service.SocgenEmployeeservice;

/*front controller */
@RestController
public class SocgenEmployeecontroller {

	@Autowired
	SocgenEmployeeservice socgenEmployeeservice ;

	/*employeelist in asc order with firstname*/
	@RequestMapping(path="/socgenemployeelist",method = RequestMethod.GET)
	public ResponseEntity<List<SocgenEmployee>> findall() {

		return 	new ResponseEntity<List<SocgenEmployee>>(socgenEmployeeservice.getEmployeesslist() ,HttpStatus.ACCEPTED) ;
	}
	
	/*register employee and stored in to db schema societegeneral*/
	@RequestMapping(path="/createsocgenemployee",method = RequestMethod.POST)
	public ResponseEntity<String> createSocgenEmployee(@RequestBody SocgenEmployee socgenEmployee)
	{
		socgenEmployee = socgenEmployeeservice.createsocgenemployee(socgenEmployee);
		HttpStatus str = socgenEmployee != null ? HttpStatus.CREATED:HttpStatus.INTERNAL_SERVER_ERROR;
		return new ResponseEntity<String>(str);
	}
	
	
	@RequestMapping(path="/departmentnames",method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getDepartmentNames() {

		Department d1 = new Department("Engineering","Engineering");
		Department d2 = new Department("HR","HR");
		Department d3 = new Department("marketing","marketing");
		List<Department> list = new ArrayList<Department>();
		list.add(d1);list.add(d2);list.add(d3);
		return 	new ResponseEntity<List<Department>>(list ,HttpStatus.ACCEPTED) ;
	}
}
