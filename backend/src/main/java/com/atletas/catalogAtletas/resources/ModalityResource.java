package com.atletas.catalogAtletas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atletas.catalogAtletas.dto.ModalityDTO;
import com.atletas.catalogAtletas.services.ModalityService;

@RestController
@RequestMapping(value = "/modalities")
public class ModalityResource {

	@Autowired
	private ModalityService modalityService;

	@GetMapping
	public ResponseEntity<List<ModalityDTO>> findAll() {
		List<ModalityDTO> list = modalityService.findAll();

		return ResponseEntity.ok(list);

	}

}
