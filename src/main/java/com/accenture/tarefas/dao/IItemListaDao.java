package com.accenture.tarefas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.tarefas.entity.ItemLista;

public interface IItemListaDao extends JpaRepository<ItemLista, ItemLista> {

	@Query("SELECT item " +
			" FROM ItemLista item " +
			" Join ListaTarefa listaTarefa on "+
			" listaTarefa.id = item.listaTarefa.id "+
			" where listaTarefa.id = ?1 ")
	public List<ItemLista> findbyIdLista(Long idLista);
}
