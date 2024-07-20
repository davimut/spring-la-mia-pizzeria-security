package it.davimut.pizzeria.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ingrediente")
public class IngredienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank (message = "ingredienti obbligatori")
	@Column(name = "ingrediente", nullable = false)
	private String ingrediente;
	
	@ManyToMany(mappedBy ="ingredienti")
	private List<PizzaModel> pizze;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public List<PizzaModel> getPizze() {
		return pizze;
	}

	public void setPizze(List<PizzaModel> pizze) {
		this.pizze = pizze;
	}
	
	
}
