package com.atletas.catalogAtletas.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atletas.catalogAtletas.dto.HistoricEventDTO;
import com.atletas.catalogAtletas.entities.HistoricEvent;
import com.atletas.catalogAtletas.repositories.HistoricEventRepository;
import com.atletas.catalogAtletas.services.exception.DataBaseException;
import com.atletas.catalogAtletas.services.exception.ResourceNotFoundException;

@Service
public class HistoricEventService {

	@Autowired
	private HistoricEventRepository historicEventRepository;

	@Transactional(readOnly = true)
	public HistoricEventDTO findById(Long id) {
		Optional<HistoricEvent> obj = historicEventRepository.findById(id);

		HistoricEvent entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new HistoricEventDTO(entity);
	}

	@Transactional
	public HistoricEventDTO save(HistoricEventDTO dto) {

		HistoricEvent entity = new HistoricEvent();

		copyDtoToEntity(dto, entity);

		entity = historicEventRepository.save(entity);

		return new HistoricEventDTO(entity);
	}

	@Transactional
	public HistoricEventDTO update(Long id, HistoricEventDTO dto) {

		try {
			HistoricEvent entity = historicEventRepository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = historicEventRepository.save(entity);
			return new HistoricEventDTO(entity);
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		}

	}

	public void delete(Long id) {
		try {
			historicEventRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}

	}

	private void copyDtoToEntity(HistoricEventDTO dto, HistoricEvent entity) {
		entity.setId(dto.getId());
		entity.setSchoolName(dto.getSchoolName());
		entity.setCategoryName(dto.getCategoryName());
		entity.setModalityName(dto.getModalityName());
	}

}
