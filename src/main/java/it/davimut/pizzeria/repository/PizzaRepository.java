package it.davimut.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.davimut.pizzeria.model.PizzaModel;

public interface PizzaRepository extends JpaRepository<PizzaModel, Integer> {

}
