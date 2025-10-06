package com.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entites.RoleBook;
import com.boot.repo.RoleBookRepo;

@Service
public class RoleBookService 
{
	@Autowired
	RoleBookRepo rpr;
	
	public RoleBook insertData(RoleBook r1)
	{
		RoleBook data = rpr.save(r1);
		if(data!=null)
		return data;
		else
			return null;
	}
	
	public RoleBook deleteData(int id) {
	    RoleBook row = rpr.findById(id)
	                      .orElseThrow(() -> new RuntimeException("Record not found with id: " + id));
	    rpr.delete(row);
	    return row;
	}

	
	public Iterable<RoleBook> selectData()
	{
		Iterable<RoleBook> data= rpr.findAll();
		return data;
	}
}
