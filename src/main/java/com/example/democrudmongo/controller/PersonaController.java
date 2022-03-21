package com.example.democrudmongo.controller;

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

import com.example.democrudmongo.model.Persona;
import com.example.democrudmongo.service.api.PersonaServiceApi;

@RestController
@RequestMapping("persona/api/v1")
@CrossOrigin("*")
public class PersonaController {
	
	@Autowired
	private PersonaServiceApi personaServiceApi;
	
	@GetMapping(value ="/all")
	public List<Persona >getAll(){
		return personaServiceApi.getAll();
	}
	
	@GetMapping(value="/find({id}")
	public Persona find(@PathVariable Long id) {
		return personaServiceApi.get(id);
	}
	 @PostMapping(value="/save")
	 public ResponseEntity<Persona>save(@RequestBody Persona persona){
		 Persona obj = personaServiceApi.save(persona);
		 return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	 }
	 
	 @GetMapping(value="/delete/{id}")
	 /*clase de eliminacion*/
	 public ResponseEntity<Persona>delete(@RequestBody Long id){
		 Persona persona = personaServiceApi.get(id);
		 if(persona != null) {
			 personaServiceApi.delete(id);
			 
		 }else {
			 return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<Persona>(persona,HttpStatus.OK);
	 }
}
