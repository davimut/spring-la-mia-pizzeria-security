package it.davimut.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.davimut.pizzeria.model.OffertaModel;
import it.davimut.pizzeria.repository.OffertaRepo;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaController {
	@Autowired
	private OffertaRepo OffertaRepo;

	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("offerta") OffertaModel offerta, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "/offerte/edit";
		}

		OffertaRepo.save(offerta);

		return "redirect:/pizzeria/dettaglio/" + offerta.getPizza().getId();
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		OffertaRepo.deleteById(id);
		
	
		return "redirect:/pizzeria/dettaglio/";
}
	}
