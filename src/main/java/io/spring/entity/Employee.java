package io.spring.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {

	private @Id @GeneratedValue Long  id; 
	private String name;
	private String role;

	public Employee(){
		
	}
	
	public Employee(String name, String role){
		this.name = name;
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Employee)) {
			return false;
		}
		
		Employee employee = (Employee) obj;
		
		return Objects.equals(this.getId() , employee.getId()) &&
			   Objects.equals(this.getName() , employee.getName()) &&
			   Objects.equals(this.getRole() , employee.getRole());
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id, name, role);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
}
