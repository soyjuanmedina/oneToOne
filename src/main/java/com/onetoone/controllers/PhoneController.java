package com.onetoone.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.models.Phone;
import com.onetoone.repository.PhoneRepository;

@RestController
@RequestMapping("/phone")
public class PhoneController {
	
	@Autowired
	PhoneRepository phoneRepository;
	
	@PostMapping("/save")
	public  ResponseEntity<Boolean> savePhone(@RequestBody Phone phone) {
		phoneRepository.save(phone);
		return ResponseEntity.ok(true);
	}
	
	@PostMapping("/get")
	public ResponseEntity<Optional<Phone>> getPhone(@RequestBody int i) {

		Long id = Long.valueOf(i);
		Optional<Phone> phone = phoneRepository.findById(id);

		return ResponseEntity.ok(phone);
	}

}
