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
import com.app.ecirak.repository.SDistrictRepository;

@RestController
@RequestMapping(value = "/SDistrict", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SDistrictRestController {
	@Autowired	
	private SDistrictRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<SDistrict> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<SDistrict> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	// Find By CityId
	@GetMapping ("/list/{id}")
	public List<SDistrict> findByCity_id(@PathVariable("id") Integer city_id){
		return repository.findByCity_id(city_id);		
	}
	
	// Find By Name
	@GetMapping ("/list/by/{prm}")
	public List<SDistrict> getByName(@PathVariable("prm") String name){
		return repository.findByName(name);		
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<SDistrict> deleteDistrictById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SDistrict> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public SDistrict createDistrict(@RequestBody SDistrict sdistrict) {
		repository.save(sdistrict);
		return sdistrict;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<SDistrict> update(@PathVariable("id") int id,
	                                        @RequestBody SDistrict sdistrict){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(sdistrict.getId());
	            record.setName(sdistrict.getName());
	            record.setCity_id(sdistrict.getCity_id());
	            SDistrict updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	

}
