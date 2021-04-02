package com.accenture.tarefas.service;

import java.util.List;

import com.accenture.tarefas.entity.Item;

public interface IItemService {

	public Item salvar(Item item);
	public void excluir(Item itema);
	public List<Item> listar();
	
}
