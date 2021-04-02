package com.accenture.tarefas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.internal.runners.TestClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.tarefas.entity.Item;
import com.accenture.tarefas.service.IItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuiteClasses({TestClass.class})
@SpringBootTest(classes = TarefasApplication.class)
@RunWith(SpringRunner.class)
@WithMockUser
public class ItemControllerTest {
	
	
	  @Autowired WebApplicationContext context;
	  
	  MockMvc mvc;
	  
	  @MockBean IItemService mock;
	  
	  @SuppressWarnings("unchecked")
	@Test public void listarTeste() throws Exception {
	  
	  this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	  
	  Item item = new Item();
	  item.setDescricao("Teste");
	  List<Item> listaResponse = new ArrayList<Item>();
	  
	  listaResponse.add(item);
	  
	  
	  Mockito.when(mock.listar()).thenReturn(listaResponse);
	  
	  
	  RequestBuilder requestBuilder = MockMvcRequestBuilders
	  .get("/api/v1/item/listar")
	  .accept(MediaType.APPLICATION_JSON);
	  
	  
	  MvcResult result = mvc.perform(requestBuilder).andReturn();
	  
	  
	  String json = result.getResponse().getContentAsString();
	  
	  List<Item> lista = new ObjectMapper().readValue(json,  new TypeReference<List<Item>>(){});
	  assertEquals("Teste",lista.get(0).getDescricao());
	  
	  }
	 
}