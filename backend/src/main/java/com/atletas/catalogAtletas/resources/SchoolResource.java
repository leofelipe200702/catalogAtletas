package com.atletas.catalogAtletas.resources;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SchoolDTO> findById(@PathVariable Long id) {
		SchoolDTO dto = schoolService.findById(id);
		return ResponseEntity.ok(dto);

	}

	@PostMapping
	public ResponseEntity<SchoolDTO> save(@RequestBody SchoolDTO school) {

		school = schoolService.save(school);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(school.getId())
				.toUri();

		return ResponseEntity.created(uri).body(school);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<SchoolDTO> update(@PathVariable Long id, @RequestBody SchoolDTO school) {

		school = schoolService.update(id, school);

		return ResponseEntity.ok().body(school);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SchoolDTO> delete(@PathVariable Long id) {

		schoolService.delete(id);
		return ResponseEntity.noContent().build();

	}


}
