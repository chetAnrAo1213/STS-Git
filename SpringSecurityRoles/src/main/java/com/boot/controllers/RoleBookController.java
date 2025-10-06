package com.boot.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entites.RoleBook;
import com.boot.service.RoleBookService;


@RestController
@RequestMapping("/roles")
public class RoleBookController 
{
	
	@Autowired
	RoleBookService rbs;
	
	@GetMapping("/get")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<Iterable<RoleBook>> getMethodName() 
	{
		Iterable<RoleBook> data = rbs.selectData();
		return ResponseEntity.of(Optional.of(data));
	}
	
	@PostMapping("/post")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<RoleBook> postMethodName(@RequestBody RoleBook rb) 
	{	
		 RoleBook r1 =  rbs.insertData(rb);
		 return ResponseEntity.of(Optional.of(r1));
	}
	
	@DeleteMapping("/del/{id}")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<RoleBook> deleteMapping(@PathVariable("id") int id)
	{
		RoleBook data =  rbs.deleteData(id);
		return ResponseEntity.of(Optional.of(data));
	}
	
}
