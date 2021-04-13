package com.instructorrob.petshelter.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instructorrob.petshelter.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long>{
	//other custom methods or modifications of the CrudRepository methods
	List<Pet> findAll();
	
	
	
	
	
	
	

}
