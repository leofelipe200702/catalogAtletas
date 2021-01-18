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

	@GetMapping(value = "/{id}")
	public ResponseEntity<ModalityDTO> findById(@PathVariable Long id) {
		ModalityDTO dto = modalityService.findById(id);
		return ResponseEntity.ok(dto);

	}

	@PostMapping
	public ResponseEntity<ModalityDTO> save(@RequestBody ModalityDTO modality) {

		modality = modalityService.save(modality);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(modality.getId())
				.toUri();

		return ResponseEntity.created(uri).body(modality);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ModalityDTO> update(@PathVariable Long id, @RequestBody ModalityDTO modality) {

		modality = modalityService.update(id, modality);

		return ResponseEntity.ok().body(modality);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ModalityDTO> delete(@PathVariable Long id) {

		modalityService.delete(id);
		return ResponseEntity.noContent().build();

	}

}
