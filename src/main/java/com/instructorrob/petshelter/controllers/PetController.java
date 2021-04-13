package com.instructorrob.petshelter.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instructorrob.petshelter.models.Pet;
import com.instructorrob.petshelter.services.PetService;

@Controller
public class PetController {
	
	private final PetService pService;
	
	//when a constructor get this service instance passed to it upon creation, that is dependency injection
	public PetController(PetService service) {
		this.pService = service;
	}
	
	@RequestMapping("/pets")
	public String index(Model viewModel) {
		
		
		viewModel.addAttribute("allPets", this.pService.getAllPets());
		
		
		return "home.jsp";
	}
	
	@RequestMapping("/pets/new")
    public String newPet(@ModelAttribute("pet") Pet pet) {
        return "new.jsp";
    }
	
	
	@RequestMapping(value="/pets/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("pet") Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            this.pService.createPet(pet);
            return "redirect:/pets";
        }
    }
	
	@RequestMapping(value="/pets/{id}")
	public String showOnePet(@PathVariable("id") Long id, Model viewModel) {
		Pet pettoShow = this.pService.getPet(id);
		viewModel.addAttribute("petToShow", pettoShow);
		
		return "onepet.jsp";
	}
	
	@RequestMapping("/pets/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Pet pet = this.pService.getPet(id);
        model.addAttribute("pet", pet);
        return "edit.jsp";
    }
	
	@RequestMapping(value="/pets/{id}/update", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("pet") Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	this.pService.updatePet(pet);
            return "redirect:/pets";
        }
    }
	
	@RequestMapping(value="/pets/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        this.pService.deletePet(id);
        return "redirect:/pets";
    }


	
	
	

	

}
