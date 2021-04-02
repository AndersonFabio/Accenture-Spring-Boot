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

import com.accenture.tarefas.entity.ListaTarefa;
import com.accenture.tarefas.service.IListaTarefaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/listatarefa/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class ListaTarefaController {

	@Autowired
	private IListaTarefaService listaTarefaService;

	@GetMapping("listar")
	public ResponseEntity<List<ListaTarefa>> listar() {
		log.info("Inicio da operação listar ListaTarefa");
		List<ListaTarefa> listaTarefa = this.listaTarefaService.listar();
		log.info("Fim da operação listar ListaTarefa");
		return new ResponseEntity<>(listaTarefa, HttpStatus.OK);
	}

	@PostMapping("salvar")
	public ResponseEntity<ListaTarefa> salvar(@RequestBody ListaTarefa listaTarefa) {
		log.info("Inicio da operação salvar ListaTarefa");
		listaTarefa = this.listaTarefaService.salvar(listaTarefa);
		log.info("Fim da operação salvar ListaTarefa");
		return new ResponseEntity<>(listaTarefa, HttpStatus.OK);
	}

	@PostMapping("excluir")
	public ResponseEntity<ListaTarefa> excluir(@RequestBody ListaTarefa listaTarefa) {
		log.info("Inicio da operação excluir ListaTarefa");
		this.listaTarefaService.excluir(listaTarefa);
		log.info("Fim da operação salvar ListaTarefa");
		return new ResponseEntity<>(listaTarefa, HttpStatus.OK);
	}

}
