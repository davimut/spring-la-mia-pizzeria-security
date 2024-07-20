package it.davimut.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import it.davimut.pizzeria.model.IngredienteModel;
import it.davimut.pizzeria.repository.IngredienteRepo;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {

	@Autowired
	private IngredienteRepo IngredienteRepo ;
	
	
	@GetMapping
	public String index(Model model) {
		
		model.addAttribute("listaIngredienti", IngredienteRepo.findAll());
		model.addAttribute("ingrediente", new IngredienteModel());
		
		return "/ingredienti/index";
	}
	
	@PostMapping("/create")
	public String store(
	        @Valid @ModelAttribute("ingrediente") IngredienteModel ingrediente,
	        BindingResult bindingResult,
	        Model model) {
	    
	    // Controlla se l'ingrediente è già presente nel database
	    if (ingrediente.getIngrediente() != null) {
	        IngredienteModel ingredienteFiltrato = IngredienteRepo.findByIngredienteIgnoreCase(ingrediente.getIngrediente());
	        if (ingredienteFiltrato != null) {
	            bindingResult.addError(new ObjectError("Errore di inserimento", "l'ingrediente inserito esiste già"));
	        }
	    }
	    
	    if (bindingResult.hasErrors()) {
	        model.addAttribute("listaIngredienti", IngredienteRepo.findAll());
	        return "/ingredienti/index";
	    }
	    
	    IngredienteRepo.save(ingrediente);
	    return "redirect:/ingredienti";
	}

	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		IngredienteRepo.deleteById(id);
		
		return "redirect:/ingredienti";
	}
} 