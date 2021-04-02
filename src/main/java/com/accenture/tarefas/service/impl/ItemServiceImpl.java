package com.accenture.tarefas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tarefas.dao.IItemDao;
import com.accenture.tarefas.entity.Item;
import com.accenture.tarefas.service.IItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	IItemDao itemDao;
	
	@Override
	public Item salvar(Item item) {
		item = itemDao.save(item);
		log.info("Persistindo Item id: "+item.getId());
		return item;
	}

	@Override
	public void excluir(Item item) {
		itemDao.delete(item);
		log.info("Excluindo Item id: "+item.getId());
	}

	@Override
	public List<Item> listar() {
		List<Item> listaTarefa = itemDao.findAll();
		return listaTarefa;
	}

}
