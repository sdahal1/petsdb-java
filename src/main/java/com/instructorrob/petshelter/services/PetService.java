package com.instructorrob.petshelter.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.instructorrob.petshelter.models.Pet;
import com.instructorrob.petshelter.repositories.PetRepository;

@Service 
public class PetService {
	private final PetRepository pRepo;
	
	//this is a constructor
	public PetService(PetRepository petRepository) {
		this.pRepo = petRepository;
	}
	
	//gets all pets
	public List<Pet> getAllPets(){
		return this.pRepo.findAll();
	}
	
	// creates a pet
    public Pet createPet(Pet p) {
        return this.pRepo.save(p);
    }

}
