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
import com.app.ecirak.entity.SUser;
import com.app.ecirak.repository.SUserRepository;

@RestController
@RequestMapping(value = "/SUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SUserRestController {
	@Autowired	
	private SUserRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<SUser> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<SUser> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	//Find By Type
	@GetMapping ("/list/by/{prm}")
	public List<SUser> findById(@PathVariable("prm") String type){
		return repository.findByType(type);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<SUser> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SUser> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public SUser create(@RequestBody SUser suser) {
		repository.save(suser);
		return suser;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<SUser> update(@PathVariable("id") int id,
	                                        @RequestBody SUser suser){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(suser.getId());
	            record.setAddress(suser.getAddress());
	            record.setMail(suser.getMail());
	            record.setNameSurname(suser.getNameSurname());
	            record.setPhone(suser.getPhone());
	            record.setUsername(suser.getUsername());
	            record.setIdentityNumber(suser.getIdentityNumber());
	            record.setNeighborhood_id(suser.getNeighborhood_id());
	            record.setCity_id(suser.getCity_id());
	            record.setDistrict_id(suser.getDistrict_id());
	            record.setSchool_id(suser.getSchool_id());
	            record.setCompany_id(suser.getCompany_id());
	            SUser updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
}
