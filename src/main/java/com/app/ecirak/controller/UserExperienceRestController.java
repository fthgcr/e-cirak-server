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

import com.app.ecirak.entity.UserExperience;
import com.app.ecirak.repository.UserExperienceRepository;


@RestController
@RequestMapping(value = "/UserExperience", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserExperienceRestController {
	@Autowired	
	private UserExperienceRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<UserExperience> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<UserExperience> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<UserExperience> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserExperience> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public UserExperience create(@RequestBody UserExperience userExperience) {
		repository.save(userExperience);
		return userExperience;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<UserExperience> update(@PathVariable("id") int id,
	                                        @RequestBody UserExperience userExperience){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(userExperience.getId());
	            record.setCompanyReviews(userExperience.getCompanyReviews());
	            record.setFinishDate(userExperience.getFinishDate());
	            record.setStartDate(userExperience.getStartDate());
	            record.setUser_id(userExperience.getUser_id());
	            record.setRelated_user_id(userExperience.getRelated_user_id());
	            UserExperience updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
