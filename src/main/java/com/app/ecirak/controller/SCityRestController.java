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

import com.app.ecirak.entity.SCity;
import com.app.ecirak.repository.SCityRepository;

@RestController
@RequestMapping(value = "/SCity", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SCityRestController {
	@Autowired	
	private SCityRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<SCity> getCityByID() {
		return repository.findAll();
	}

	//Find By Id
	@GetMapping ("/{id}")
	public Optional<SCity> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	//Find By Name
	@GetMapping ("/list/by/{prm}")
	public List<SCity> getByName(@PathVariable("prm") String name) {
		return repository.findByName(name);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<SCity> deleteCityById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SCity> (HttpStatus.ACCEPTED);
	}

		
	// Create
	@PostMapping("/")
	public SCity createCity(@RequestBody SCity scity) {
		repository.save(scity);
		return scity;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<SCity> update(@PathVariable("id") int id,
	                                        @RequestBody SCity scity){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(scity.getId());
	            record.setName(scity.getName());
	            SCity updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	

}
