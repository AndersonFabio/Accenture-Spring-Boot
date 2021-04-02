package com.accenture.tarefas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tarefas.dao.IItemListaDao;
import com.accenture.tarefas.entity.ItemLista;
import com.accenture.tarefas.service.IItemListaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemListaServiceImpl implements IItemListaService {

	@Autowired
	IItemListaDao itemListaDao;
	
	@Override
	public ItemLista salvar(ItemLista itemLista) {
		itemLista = itemListaDao.save(itemLista);
		log.info("Persistindo ItemLista id: "+itemLista.getId());
		return itemLista;
	}

	@Override
	public void excluir(ItemLista itemLista) {
		itemListaDao.delete(itemLista);
		log.info("Excluindo ItemLista id: "+itemLista.getId());
	}

	@Override
	public List<ItemLista> listar(Long idLista) {
		List<ItemLista> listaTarefa = itemListaDao.findbyIdLista(idLista);
		return listaTarefa;
	}

}
