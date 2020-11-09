package com.service.db.crud.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.service.db.crud.model.Employee;
 
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
}