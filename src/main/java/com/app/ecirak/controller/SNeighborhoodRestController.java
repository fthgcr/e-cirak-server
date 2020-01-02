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

import com.app.ecirak.entity.SDistrict;
import com.app.ecirak.entity.SNeighborhood;
import com.app.ecirak.repository.SNeighborhoodRepository;

@RestController
@RequestMapping(value = "/SNeighborhood", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SNeighborhoodRestController {
	@Autowired	
	private SNeighborhoodRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<SNeighborhood> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<SNeighborhood> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	//Find By Name
	@GetMapping ("/list/by/{prm}")
	public List<SNeighborhood> getByName(@PathVariable("prm") String name){
		return repository.findByName(name);
	}
	
	// Find By DistrictdId
	@GetMapping ("/list/{id}")
	public List<SNeighborhood> findByDistrict_id(@PathVariable("id") Integer district_id){
		return repository.findByDistrict_id(district_id);		
	}
	
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<SNeighborhood> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SNeighborhood> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public SNeighborhood createNeighborhood(@RequestBody SNeighborhood sneighborhood) {
		repository.save(sneighborhood);
		return sneighborhood;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<SNeighborhood> update(@PathVariable("id") int id,
	                                        @RequestBody SNeighborhood sneighborhood){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(sneighborhood.getId());
	            record.setName(sneighborhood.getName());
	            record.setDistrict_id(sneighborhood.getDistrict_id());
	            SNeighborhood updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
