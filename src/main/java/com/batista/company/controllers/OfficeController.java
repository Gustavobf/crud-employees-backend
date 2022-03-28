package com.batista.company.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batista.company.dto.OfficeDTO;
import com.batista.company.services.OfficeService;

@RestController
@RequestMapping(value = "/api/offices")
public class OfficeController {

	@Autowired
	private OfficeService officeService;

	@GetMapping
	public ResponseEntity<List<OfficeDTO>> getAll() {
		List<OfficeDTO> list = officeService.getAll();
		return ResponseEntity.status(200).body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OfficeDTO> getById(@PathVariable Long id) {
		OfficeDTO officeDTO = officeService.getById(id);
		return ResponseEntity.status(200).body(officeDTO);
	}
	
	@GetMapping("/findByName")
	public ResponseEntity<OfficeDTO> getByName(@RequestParam("name") String name) {
		OfficeDTO officeDTO = officeService.getByName(name);
		return ResponseEntity.status(200).body(officeDTO);
	}

	@PostMapping
	public ResponseEntity<OfficeDTO> save(@Valid @RequestBody OfficeDTO officeDTO) {
		officeDTO = officeService.save(officeDTO);
		return ResponseEntity.status(201).body(officeDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		officeService.delete(id);
		return ResponseEntity.status(204).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<OfficeDTO> update(@PathVariable Long id, @Valid @RequestBody OfficeDTO dto) {
		OfficeDTO officeDTO = officeService.update(id, dto);
		return ResponseEntity.status(200).body(officeDTO);
	}

}