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

import com.atletas.catalogAtletas.dto.ModalityDTO;
import com.atletas.catalogAtletas.entities.Modality;
import com.atletas.catalogAtletas.repositories.ModalityRepository;
import com.atletas.catalogAtletas.services.exception.DataBaseException;
import com.atletas.catalogAtletas.services.exception.ResourceNotFoundException;

@Service
public class ModalityService {

	@Autowired
	private ModalityRepository modalityRepository;

	@Transactional(readOnly = true)
	public List<ModalityDTO> findAll() {
		List<Modality> list = modalityRepository.findAll();
		return list.stream().map(x -> new ModalityDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ModalityDTO findById(Long id) {
		Optional<Modality> obj = modalityRepository.findById(id);

		Modality entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new ModalityDTO(entity);
	}

	@Transactional
	public ModalityDTO save(ModalityDTO dto) {

		Modality entity = new Modality();
		entity.setName(dto.getName());
		entity = modalityRepository.save(entity);

		return new ModalityDTO(entity);
	}

	@Transactional
	public ModalityDTO update(Long id, ModalityDTO dto) {

		try {
			Modality entity = modalityRepository.getOne(id);
			entity.setName(dto.getName());
			entity = modalityRepository.save(entity);
			return new ModalityDTO(entity);
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		}

	}

	public void delete(Long id) {
		try {
			modalityRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}
		
	}

}
