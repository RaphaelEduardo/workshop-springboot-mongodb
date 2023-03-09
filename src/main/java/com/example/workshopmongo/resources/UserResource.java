package com.example.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	/*
	 * ResponseEntity vai encapsular toda uma estrutura necessaria 
	 * para retornar respostas http (com possiveis cabeçalhos, erros, etc).
	 */
	
	//Modelo alternativo --> @RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
	
	
	
}
