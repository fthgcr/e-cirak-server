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

import com.app.ecirak.entity.Company;
import com.app.ecirak.repository.CompanyRepository;

@RestController
@RequestMapping(value = "/Company", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CompanyRestController {
	@Autowired	
	private CompanyRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<Company> get() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<Company> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Company> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Company> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public Company create(@RequestBody Company company) {
		repository.save(company);
		return company;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<Company> update(@PathVariable("id") int id,
	                                        @RequestBody Company company){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(company.getId());
	            record.setName(company.getName());
	            record.setAddress(company.getAddress());
	            record.setNeighborhood_id(company.getNeighborhood_id());
	            record.setCity_id(company.getCity_id());
	            record.setDistrict_id(company.getDistrict_id());
	            Company updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
}
