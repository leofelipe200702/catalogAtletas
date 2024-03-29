package com.atletas.catalogAtletas.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atletas.catalogAtletas.dto.AthleteHistoricDTO;
import com.atletas.catalogAtletas.entities.AthleteHistoric;
import com.atletas.catalogAtletas.entities.AthleticHistoricPk;
import com.atletas.catalogAtletas.repositories.AthleteHistoricRepository;
import com.atletas.catalogAtletas.services.exception.DataBaseException;
import com.atletas.catalogAtletas.services.exception.ResourceNotFoundException;

@Service
public class AthleteHistoricService {

	@Autowired
	private AthleteHistoricRepository athleteHistoricRepository;

	@Transactional(readOnly = true)
	public AthleteHistoricDTO findById(AthleticHistoricPk pk) {
		Optional<AthleteHistoric> obj = athleteHistoricRepository.findByPk(pk);
		
		AthleteHistoric entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new AthleteHistoricDTO(entity);
	}

	@Transactional
	public AthleteHistoricDTO save(AthleteHistoricDTO dto) {

		AthleteHistoric entity = new AthleteHistoric();

		copyDtoToEntity(dto, entity);

		entity = athleteHistoricRepository.save(entity);

		return new AthleteHistoricDTO(entity);
	}

	@Transactional
	public AthleteHistoricDTO update(AthleticHistoricPk pk, AthleteHistoricDTO dto) {

		try {
			AthleteHistoric entity = athleteHistoricRepository.getOne(pk);
			copyDtoToEntity(dto, entity);
			entity = athleteHistoricRepository.save(entity);
			return new AthleteHistoricDTO(entity);
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException("Id Not Found " + pk.getAthleteId());
		}

	}
	
	public void delete(AthleticHistoricPk pk) {
		try {
			athleteHistoricRepository.deleteById(pk);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found " + pk.getAthleteId());
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}

	}

	private void copyDtoToEntity(AthleteHistoricDTO dto, AthleteHistoric entity) {
		AthleticHistoricPk pk = new AthleticHistoricPk();
		pk.setAthleteId(dto.getId_athlete());
		pk.setYear(dto.getYear());

		entity.setPk(pk);
	}

}
