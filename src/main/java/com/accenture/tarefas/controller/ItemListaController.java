package com.accenture.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tarefas.entity.ItemLista;
import com.accenture.tarefas.service.IItemListaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/itemlista/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ItemListaController {

	@Autowired
	private IItemListaService itemListaService;

	@GetMapping("listar/{idLista}")
	public ResponseEntity<List<ItemLista>> listar(@PathVariable("idLista") Long idLista) {
		log.info("Inicio da operação listar ItemLista");
		List<ItemLista> itemLista = this.itemListaService.listar(idLista);
		log.info("Fim da operação listar ItemLista");
		return new ResponseEntity<>(itemLista, HttpStatus.OK);
	}
	
	@PostMapping("salvar")
	public ResponseEntity<ItemLista> salvar(@RequestBody 	ItemLista itemLista) {
		log.info("Inicio da operação salvar ItemLista");
		itemLista = this.itemListaService.salvar(itemLista);
		log.info("Fim da operação salvar ItemLista");
		return new ResponseEntity<>(itemLista, HttpStatus.OK);
	}
	
	@PostMapping("excluir")
	public ResponseEntity<ItemLista> excluir(@RequestBody	ItemLista itemLista) {
		log.info("Inicio da operação excluir ItemLista");
		this.itemListaService.excluir(itemLista);
		log.info("Fim da operação salvar ItemLista");
		return new ResponseEntity<>(itemLista, HttpStatus.OK);
	}

}
