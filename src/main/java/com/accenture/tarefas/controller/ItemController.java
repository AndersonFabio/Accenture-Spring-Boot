package com.accenture.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tarefas.entity.Item;
import com.accenture.tarefas.service.IItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/item/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ItemController {

	@Autowired
	private IItemService itemService;

	@GetMapping("listar")
	public ResponseEntity<List<Item>> listar() {
		log.info("Inicio da operação listar Item");
		List<Item> item = this.itemService.listar();
		log.info("Fim da operação listar Item");
		return new ResponseEntity<>(item, HttpStatus.OK);
	}
	
	@PostMapping("salvar")
	public ResponseEntity<Item> salvar(@RequestBody 	Item item) {
		log.info("Inicio da operação salvar Item");
		item = this.itemService.salvar(item);
		log.info("Fim da operação salvar Item");
		return new ResponseEntity<>(item, HttpStatus.OK);
	}
	
	@PostMapping("excluir")
	public ResponseEntity<Item> excluir(@RequestBody	Item item) {
		log.info("Inicio da operação excluir Item");
		this.itemService.excluir(item);
		log.info("Fim da operação salvar Item");
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

}
