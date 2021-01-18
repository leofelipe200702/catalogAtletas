package com.atletas.catalogAtletas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atletas.catalogAtletas.dto.SchoolDTO;
import com.atletas.catalogAtletas.entities.School;
import com.atletas.catalogAtletas.repositories.SchoolRepository;
import com.atletas.catalogAtletas.services.exception.DataBaseException;
import com.atletas.catalogAtletas.services.exception.ResourceNotFoundException;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	@Transactional(readOnly = true)
	public List<SchoolDTO> findAll() {
		List<School> list = schoolRepository.findAll();
		return list.stream().map(x -> new SchoolDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public SchoolDTO findById(Long id) {
		Optional<School> obj = schoolRepository.findById(id);

		School entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new SchoolDTO(entity);
	}

	@Transactional
	public SchoolDTO save(SchoolDTO dto) {

		School entity = new School();
		entity.setName(dto.getName());
		entity = schoolRepository.save(entity);

		return new SchoolDTO(entity);
	}

	@Transactional
	public SchoolDTO update(Long id, SchoolDTO dto) {

		try {
			School entity = schoolRepository.getOne(id);
			entity.setName(dto.getName());
			entity = schoolRepository.save(entity);
			return new SchoolDTO(entity);
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		}

	}

	public void delete(Long id) {
		try {
			schoolRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}

	}

}
