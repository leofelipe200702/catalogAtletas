package com.atletas.catalogAtletas.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.atletas.catalogAtletas.dto.UserDTO;
import com.atletas.catalogAtletas.dto.UserInsertDTO;
import com.atletas.catalogAtletas.dto.UserUpdateDTO;
import com.atletas.catalogAtletas.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "firstName") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<UserDTO> Users = userService.findAllPaged(pageRequest);

		return ResponseEntity.ok(Users);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		UserDTO dto = userService.findById(id);
		return ResponseEntity.ok(dto);

	}

	@PostMapping
	public ResponseEntity<UserDTO> save(@Valid @RequestBody UserInsertDTO dto) {

		UserDTO newDTO = userService.save(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDTO.getId())
				.toUri();

		return ResponseEntity.created(uri).body(newDTO);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id,@Valid @RequestBody UserUpdateDTO User) {

		UserDTO userDTO = userService.update(id, User);

		return ResponseEntity.ok().body(userDTO);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDTO> delete(@PathVariable Long id) {

		userService.delete(id);
		return ResponseEntity.noContent().build();

	}

}
