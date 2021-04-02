package com.accenture.tarefas.service;

import java.util.List;

import com.accenture.tarefas.entity.ListaTarefa;

public interface IListaTarefaService {

	public ListaTarefa salvar(ListaTarefa listaTarefa);
	public void excluir(ListaTarefa listaTarefa);
	public List<ListaTarefa> listar();
	
}
