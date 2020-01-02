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

import com.app.ecirak.entity.SpecialCase;
import com.app.ecirak.repository.SpecialCaseRepository;



@RestController
@RequestMapping(value = "/SpecialCase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SpecialCaseRestController {
	@Autowired	
	private SpecialCaseRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<SpecialCase> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<SpecialCase> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<SpecialCase> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SpecialCase> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public SpecialCase create(@RequestBody SpecialCase specialCase) {
		repository.save(specialCase);
		return specialCase;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<SpecialCase> update(@PathVariable("id") int id,
	                                        @RequestBody SpecialCase specialCase){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(specialCase.getId());
	            record.setValue(specialCase.getValue());
	            SpecialCase updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
