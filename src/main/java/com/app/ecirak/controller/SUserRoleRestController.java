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

import com.app.ecirak.entity.SUserRole;
import com.app.ecirak.repository.SUserRoleRepository;



@RestController
@RequestMapping(value = "/SUserRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SUserRoleRestController {
	@Autowired	
	private SUserRoleRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<SUserRole> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<SUserRole> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<SUserRole> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SUserRole> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public SUserRole create(@RequestBody SUserRole sUserRole) {
		repository.save(sUserRole);
		return sUserRole;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<SUserRole> update(@PathVariable("id") int id,
	                                        @RequestBody SUserRole sUserRole){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(sUserRole.getId());
	            record.setUser_id(sUserRole.getUser_id());
	            record.setRole_id(sUserRole.getRole_id());
	            SUserRole updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
