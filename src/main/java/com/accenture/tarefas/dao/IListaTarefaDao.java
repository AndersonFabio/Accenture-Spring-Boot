package com.accenture.tarefas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.tarefas.entity.ListaTarefa;

public interface IListaTarefaDao extends JpaRepository<ListaTarefa, ListaTarefa> {

}
