package com.boot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.entites.RoleBook;

@Repository
public interface RoleBookRepo extends CrudRepository<RoleBook, Integer>{

}
