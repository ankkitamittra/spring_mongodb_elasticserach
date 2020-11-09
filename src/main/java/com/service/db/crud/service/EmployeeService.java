package com.service.db.crud.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.db.crud.model.Employee;
import com.service.db.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
    @Autowired
    private EmployeeRepository employeeDao;
 
    public Employee createEmployee(Employee employee) {
		 return employeeDao.save(employee);
	 }

    public List<Employee> findAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeDao.findAll().forEach(employees::add);
        return employees; 
    }
    
    public Optional<Employee> getEmployeeById(String id) {
		 Optional<Employee> employee = employeeDao.findById(id);
		 return employee;
	 }
	 
	 public Employee updateEmployee(String id, Employee myPost) {
		 Optional<Employee> employees = employeeDao.findById(id);
		 if (employees.isPresent()) {
			 Employee _employee = employees.get();
			 _employee.setDesignation(myPost.getDesignation());
	    	employeeDao.save(_employee);
	    	return _employee;
		 }
		    
		return null;
	 }
	 
	 public void removeEmployee(String id) {
		 employeeDao.deleteById(id);
	 }
	 
 
}
