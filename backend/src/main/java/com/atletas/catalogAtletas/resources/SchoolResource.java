package com.atletas.catalogAtletas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atletas.catalogAtletas.dto.SchoolDTO;
import com.atletas.catalogAtletas.services.SchoolService;

@RestController
@RequestMapping(value = "/schools")
public class SchoolResource {

	@Autowired
	private SchoolService schoolService;

	@GetMapping
	public ResponseEntity<List<SchoolDTO>> findAll() {
		List<SchoolDTO> list = schoolService.findAll();

		return ResponseEntity.ok(list);

	}

}
