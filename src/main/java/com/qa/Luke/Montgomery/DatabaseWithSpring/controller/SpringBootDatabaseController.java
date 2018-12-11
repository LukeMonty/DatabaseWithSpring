package com.qa.Luke.Montgomery.DatabaseWithSpring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.Luke.Montgomery.DatabaseWithSpring.exception.ResourceNotFoundException;
import com.qa.Luke.Montgomery.DatabaseWithSpring.model.SpringBootDatabaseModel;
import com.qa.Luke.Montgomery.DatabaseWithSpring.repository.DatabaseWithSpringRepository;

@RestController
@RequestMapping("/api")
public class SpringBootDatabaseController {

	@Autowired
	DatabaseWithSpringRepository myRepository;

	@PostMapping("/person")
	public SpringBootDatabaseModel createPerson(@Valid @RequestBody SpringBootDatabaseModel springRepository) {
		return myRepository.save(springRepository);
	}

	@GetMapping("/person/{id}")
	public SpringBootDatabaseModel getPersonById(@PathVariable(value = "id") Long personID) {
		return myRepository.findById(personID)
				.orElseThrow(() -> new ResourceNotFoundException("SpringBootDatabaseModel", "id", personID));
	}

	@GetMapping("/person")
	public List<SpringBootDatabaseModel> getAllPeople() {

		return myRepository.findAll();

	}

	@PutMapping("/person/{id}")
	public SpringBootDatabaseModel updatePerson(@PathVariable(value = "id") Long personID,
			@Valid @RequestBody SpringBootDatabaseModel personDetails) {

		SpringBootDatabaseModel data = myRepository.findById(personID)
				.orElseThrow(() -> new ResourceNotFoundException("Person", "id", personID));

		data.setName(personDetails.getName());
		data.setAddress(personDetails.getAddress());
		data.setAge(personDetails.getAge());

		SpringBootDatabaseModel update = myRepository.save(data);
		return update;

	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long personID) {
		SpringBootDatabaseModel model = myRepository.findById(personID).orElseThrow(() -> new ResourceNotFoundException("Person", "id", personID));
		
		myRepository.delete(model);
		return ResponseEntity.ok(model);
		
	}

}
