package com.accenture.tarefas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.tarefas.entity.Item;

public interface IItemDao extends JpaRepository<Item, Item> {

}
