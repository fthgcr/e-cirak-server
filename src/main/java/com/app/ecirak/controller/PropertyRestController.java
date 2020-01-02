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

import com.app.ecirak.entity.Property;
import com.app.ecirak.repository.PropertyRepository;

@RestController
@RequestMapping(value = "/Property", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PropertyRestController {
	@Autowired	
	private PropertyRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<Property> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<Property> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
		
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Property> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Property> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public Property create(@RequestBody Property property) {
		repository.save(property);
		return property;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<Property> update(@PathVariable("id") int id,
	                                        @RequestBody Property property){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(property.getId());
	            record.setName(property.getName());            
	            Property updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
}
