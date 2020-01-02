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

import com.app.ecirak.entity.School;
import com.app.ecirak.repository.SchoolRepository;

@RestController
@RequestMapping(value = "/School", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SchoolRestController {
	@Autowired	
	private SchoolRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<School> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<School> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	//Find By City 
	@GetMapping ("/city/{id}")
	public List<School> getByCity(@PathVariable("id") int city_id) {
		return repository.findByCity_id(city_id);
	}
	
	//Find By District 
	@GetMapping ("/district/{id}")
	public List<School> getByDistrict(@PathVariable("id") int district_id) {
		return repository.findByDistrict_id(district_id);
	}
	
	//Find By Neighborhood 
	@GetMapping ("/neighborhood/{id}")
	public List<School> getByNeighborhood(@PathVariable("id") int neighborhood_id) {
		return repository.findByNeighborhood_id(neighborhood_id);
	}
		
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<School> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<School> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public School create(@RequestBody School school) {
		repository.save(school);
		return school;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<School> update(@PathVariable("id") int id,
	                                        @RequestBody School school){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(school.getId());
	            record.setName(school.getName());
	            record.setAddress(school.getAddress());
	            record.setZipCode(school.getZipCode());
	            record.setNeighborhood_id(school.getNeighborhood_id());
	            record.setCity_id(school.getCity_id());
	            record.setDistrict_id(school.getDistrict_id());
	            School updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
