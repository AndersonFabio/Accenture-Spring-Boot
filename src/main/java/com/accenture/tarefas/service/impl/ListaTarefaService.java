package com.accenture.tarefas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tarefas.dao.IListaTarefaDao;
import com.accenture.tarefas.entity.ListaTarefa;
import com.accenture.tarefas.service.IListaTarefaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ListaTarefaService implements IListaTarefaService {

	@Autowired
	IListaTarefaDao ListaTarefaDao;
	
	@Override
	public ListaTarefa salvar(ListaTarefa ListaTarefa) {
		ListaTarefa = ListaTarefaDao.save(ListaTarefa);
		log.info("Persistindo ListaTarefa id: "+ListaTarefa.getId());
		return ListaTarefa;
	}

	@Override
	public void excluir(ListaTarefa ListaTarefa) {
		ListaTarefaDao.delete(ListaTarefa);
		log.info("Excluindo ListaTarefa id: "+ListaTarefa.getId());
	}

	@Override
	public List<ListaTarefa> listar() {
		List<ListaTarefa> listaTarefa = ListaTarefaDao.findAll();
		return listaTarefa;
	}

}
