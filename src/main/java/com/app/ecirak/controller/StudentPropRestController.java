package com.app.ecirak.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecirak.entity.StudentProp;
import com.app.ecirak.repository.StudentPropRepository;



@RestController
@RequestMapping(value = "/StudentProp", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StudentPropRestController {
	@Autowired	
	private StudentPropRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<StudentProp> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<StudentProp> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<StudentProp> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<StudentProp> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public StudentProp create(@RequestBody StudentProp studentProp) {
		repository.save(studentProp);
		return studentProp;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<StudentProp> update(@PathVariable("id") int id,
	                                        @RequestBody StudentProp studentProp){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(studentProp.getId());
	            record.setUser_id(studentProp.getUser_id());
	            record.setProp_id(studentProp.getProp_id());
	            StudentProp updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
