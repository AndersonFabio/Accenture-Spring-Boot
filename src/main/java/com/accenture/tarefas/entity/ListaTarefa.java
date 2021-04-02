package com.accenture.tarefas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="listaTarefa")
@Data
public class ListaTarefa {
	

	@Id
	@GeneratedValue
	private Long id;
		
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="LISTATAREFAS_ID")
	private List<ItemLista> itensLista;
}
