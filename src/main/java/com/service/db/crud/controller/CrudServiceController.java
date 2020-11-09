package com.service.db.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.db.crud.model.Employee;
import com.service.db.crud.model.Posts;
import com.service.db.crud.service.EmployeeService;
import com.service.db.crud.service.PostsService;


@RestController
@RequestMapping("/api")
public class CrudServiceController {
  
  @Autowired
  PostsService postsService;
  
  @Autowired
  EmployeeService employeeService;
  
  
 //Employee Type Elastic Search Document CRUD operations
  
  @PostMapping("/employee")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee myemployee) {
	  
	  try {
		  
	  	 Employee _employee = employeeService.createEmployee(myemployee);
	     return new ResponseEntity<>(_employee, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
   }
 

  @GetMapping("/employee")
  public ResponseEntity<List<Employee>> getAllEmployees() {
	  try {
		  List<Employee> _employees = employeeService.findAllEmployees();
		  
		  if (_employees.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
	     
	      return new ResponseEntity<>( _employees, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
  }
  
  @GetMapping("/employee/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {

	Optional<Employee> _employee = employeeService.getEmployeeById(id);
    if (_employee.isPresent()) {
      return new ResponseEntity<>(_employee.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/employee/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
   
	  Employee _employee = employeeService.updateEmployee(id, employee);
    if (_employee != null) {
      return new ResponseEntity<>(_employee, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/employee/{id}")
  public ResponseEntity<HttpStatus> removeEmployee(@PathVariable("id") String id) {
    try {
    	employeeService.removeEmployee(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  
  //Post Document CRUD operations
  
   @GetMapping("/posts")
   public ResponseEntity<List<Posts>> getAllPosts() {
	  try {
	      List<Posts> posts = postsService.getAllPosts();
	      if (posts.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	
	      return new ResponseEntity<>(posts, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
   }

   @PostMapping("/posts")
   public ResponseEntity<Posts> createPosts(@RequestBody Posts myPost) {
		 
	   try {
		 Posts _post = postsService.createPost(myPost);
	     return new ResponseEntity<>(_post, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
   }

  

  @GetMapping("/posts/{id}")
  public ResponseEntity<Posts> getPostById(@PathVariable("id") String id) {

	Optional<Posts> post = postsService.getPostById(id);
	
    if (post.isPresent()) {
      return new ResponseEntity<>(post.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/posts/{id}")
  public ResponseEntity<Posts> updatePost(@PathVariable("id") String id, @RequestBody Posts post) {
   
	Posts _post = postsService.updatePost(id, post);
    if (_post != null) {
      return new ResponseEntity<>(_post, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/posts/{id}")
  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") String id) {
    try {
      postsService.deletePost(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/posts")
  public ResponseEntity<HttpStatus> deleteAllPosts() {
    try {
      postsService.deleteAllPosts();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
