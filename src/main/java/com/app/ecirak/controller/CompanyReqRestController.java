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

import com.app.ecirak.entity.CompanyReq;
import com.app.ecirak.repository.CompanyReqRepository;



@RestController
@RequestMapping(value = "/CompanyReq", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CompanyReqRestController {
	@Autowired	
	private CompanyReqRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<CompanyReq> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<CompanyReq> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
		
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<CompanyReq> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<CompanyReq> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public CompanyReq create(@RequestBody CompanyReq companyReq) {
		repository.save(companyReq);
		return companyReq;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<CompanyReq> update(@PathVariable("id") int id,
	                                        @RequestBody CompanyReq companyReq){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(companyReq.getId());
	            record.setDateTime(companyReq.getDateTime());
	            record.setUserId(companyReq.getUserId());
	            record.setProperty_id(companyReq.getProperty_id());
	            record.setCompany_id(companyReq.getCompany_id());
	            CompanyReq updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
