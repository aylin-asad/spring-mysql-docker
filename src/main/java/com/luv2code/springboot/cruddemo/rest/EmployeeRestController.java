package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId){
		Employee theEmployee =  employeeService.findById(employeeId);
		if(theEmployee == null){
			throw new RuntimeException("Employee id not found");
		}
		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee==null){
			throw new RuntimeException("Employee id not found");
		}
		employeeService.deleteById(theEmployee.getId());
		return "Employee with id: " + theEmployee.getId() + " deleted";
	}

	
}










