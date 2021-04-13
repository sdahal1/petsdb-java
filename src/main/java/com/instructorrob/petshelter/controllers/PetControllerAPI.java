package com.instructorrob.petshelter.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instructorrob.petshelter.models.Pet;
import com.instructorrob.petshelter.services.PetService;

@RestController
@RequestMapping("/api")
public class PetControllerAPI {
	
	private final PetService pService;
	
	public PetControllerAPI(PetService petService) {
		this.pService = petService;
	}
	
	
	@RequestMapping("/home")
	public String home() {
		return "hello world";
	}
	
	@RequestMapping("/all")
	public List<Pet> getAllPets(){
		return this.pService.getAllPets();
	}
	
	@RequestMapping(value="/create", method= RequestMethod.POST)
	public Pet createPet(@RequestParam("name") String name, @RequestParam("description") String desc, @RequestParam("age") Integer age) {
		
		Pet pet = new Pet(name, desc, age);
		return this.pService.createPet(pet);
		
		
	}
	
	
	
	
	
	

}
