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

import com.app.ecirak.entity.UserSpecialCase;
import com.app.ecirak.repository.UserSpecialCaseRepository;


@RestController
@RequestMapping(value = "/UserSpecialCase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserSpecialCaseRestController {
	@Autowired	
	private UserSpecialCaseRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<UserSpecialCase> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<UserSpecialCase> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<UserSpecialCase> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserSpecialCase> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public UserSpecialCase create(@RequestBody UserSpecialCase userSpecialCase) {
		repository.save(userSpecialCase);
		return userSpecialCase;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<UserSpecialCase> update(@PathVariable("id") int id,
	                                        @RequestBody UserSpecialCase userSpecialCase){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(userSpecialCase.getId());
	            record.setCase_id(userSpecialCase.getCase_id());
	            record.setUser_id(userSpecialCase.getUser_id());
	            UserSpecialCase updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
