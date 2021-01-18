package com.atletas.catalogAtletas.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atletas.catalogAtletas.dto.AthleteDTO;
import com.atletas.catalogAtletas.services.AthleteService;

@RestController
@RequestMapping(value = "/athletes")
public class AthleteResource {

	@Autowired
	private AthleteService athleteService;

	@GetMapping
	public ResponseEntity<List<AthleteDTO>> findAll() {
		List<AthleteDTO> list = athleteService.findAll();
		return ResponseEntity.ok(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AthleteDTO> findById(@PathVariable Long id) {
		AthleteDTO dto = athleteService.findById(id);
		return ResponseEntity.ok(dto);

	}

	@PostMapping
	public ResponseEntity<AthleteDTO> save(@RequestBody AthleteDTO athlete) {

		athlete = athleteService.save(athlete);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(athlete.getId())
				.toUri();

		return ResponseEntity.created(uri).body(athlete);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AthleteDTO> update(@PathVariable Long id, @Valid @RequestBody AthleteDTO athlete) {

		athlete = athleteService.update(id, athlete);

		return ResponseEntity.ok().body(athlete);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AthleteDTO> delete(@PathVariable Long id) {

		athleteService.delete(id);
		return ResponseEntity.noContent().build();

	}

}
