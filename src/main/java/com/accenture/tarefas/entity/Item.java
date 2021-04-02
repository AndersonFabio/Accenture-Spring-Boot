package com.accenture.tarefas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="item")
@Data
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;

	

}
