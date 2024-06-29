package io.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
