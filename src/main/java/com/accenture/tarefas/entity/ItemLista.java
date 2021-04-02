package com.accenture.tarefas.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="itemlista")
@Data
public class ItemLista {

	@Id
	@GeneratedValue
	private Long id;

	private Boolean concluido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ListaTarefa listaTarefa;
}
