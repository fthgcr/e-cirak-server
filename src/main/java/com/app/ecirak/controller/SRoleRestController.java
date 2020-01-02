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

import com.app.ecirak.entity.SRole;
import com.app.ecirak.repository.SRoleRepository;

@RestController
@RequestMapping(value = "/SRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SRoleRestController {
	@Autowired	
	private SRoleRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<SRole> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<SRole> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<SRole> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SRole> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public SRole create(@RequestBody SRole sRole) {
		repository.save(sRole);
		return sRole;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<SRole> update(@PathVariable("id") int id,
	                                        @RequestBody SRole sRole){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(sRole.getId());
	            record.setRoleName(sRole.getRoleName());
	            SRole updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
