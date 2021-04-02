package com.accenture.tarefas.service;

import java.util.List;

import com.accenture.tarefas.entity.ItemLista;

public interface IItemListaService {

	public ItemLista salvar(ItemLista itemLista);
	public void excluir(ItemLista itemLista);
	public List<ItemLista> listar(Long idLista);
	
}
