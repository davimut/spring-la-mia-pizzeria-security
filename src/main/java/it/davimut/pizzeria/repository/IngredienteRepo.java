package it.davimut.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.davimut.pizzeria.model.IngredienteModel;

public interface IngredienteRepo extends JpaRepository<IngredienteModel, Integer> {
	public IngredienteModel findByIngredienteIgnoreCase(String ingrediente);
}
