package io.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.spring.entity.Employee;
import io.spring.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	private final EmployeeRepository repository;

	public EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	//get oneEmployee
	@GetMapping("/employee/{id}")
	public Employee oneEmployee(@PathVariable("id") Long id) {
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}
	
	//get allEmployee
	@GetMapping("/employees")
	public List<Employee> allEmployee(){
		return repository.findAll();
	}
	
	//post newEmployee
	@PostMapping("/employee")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee newEmployee(@RequestBody Employee employee) {
		return repository.save(employee); 
	}
	//put updateEmployee
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long id) {
		return repository.findById(id).map(e -> {
			e.setName(employee.getName());
			e.setRole(employee.getRole());
			return repository.save(e);
		}).orElseGet(()-> {
			return repository.save(employee);
		});
	}
	
	//delete deleteEmployee
	@DeleteMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
