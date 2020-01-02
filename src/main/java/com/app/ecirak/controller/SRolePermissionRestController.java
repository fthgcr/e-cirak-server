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

import com.app.ecirak.entity.SRolePermission;
import com.app.ecirak.repository.SRolePermissionRepository;


@RestController
@RequestMapping(value = "/SRolePermission", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SRolePermissionRestController {
	@Autowired	
	private SRolePermissionRepository repository;
	
	// List
	@GetMapping ("/list")
	public List<SRolePermission> getByID() {
		return repository.findAll();
	}
	
	//Find By Id
	@GetMapping ("/{id}")
	public Optional<SRolePermission> findById(@PathVariable("id") int id){
		return repository.findById(id);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<SRolePermission> deleteById(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SRolePermission> (HttpStatus.ACCEPTED);
	}
	
	// Create
	@PostMapping("/")
	public SRolePermission create(@RequestBody SRolePermission sRolePermission) {
		repository.save(sRolePermission);
		return sRolePermission;
	}
	
	//Edit
	@PutMapping(value="/{id}")
	  public ResponseEntity<SRolePermission> update(@PathVariable("id") int id,
	                                        @RequestBody SRolePermission sRolePermission){
	    return repository.findById(id)
	        .map(record -> {
	            record.setId(sRolePermission.getId());
	            record.setRole_id(sRolePermission.getRole_id());
	            SRolePermission updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
}
