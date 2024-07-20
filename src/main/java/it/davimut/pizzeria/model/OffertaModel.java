package it.davimut.pizzeria.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "offerta")
public class OffertaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name = "offerta_date", nullable = false)
	private LocalDateTime offertaDate;

	@Column(name = "return_date")
	private LocalDateTime returnDate;

	private String titolo;

	@ManyToOne
	@JoinColumn(name = "pizza_id", nullable = false)
	private PizzaModel pizza;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getOffertaDate() {
		return offertaDate;
	}

	public void setOffertaDate(LocalDateTime offertaDate) {
		this.offertaDate = offertaDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public PizzaModel getPizza() {
		return pizza;
	}

	public void setPizza(PizzaModel pizza) {
		this.pizza = pizza;
	}
}
