package com.atletas.catalogAtletas.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atletas.catalogAtletas.dto.AthleteDTO;
import com.atletas.catalogAtletas.dto.AthleteResumedDTO;
import com.atletas.catalogAtletas.entities.Athlete;
import com.atletas.catalogAtletas.repositories.AthleteRepository;
import com.atletas.catalogAtletas.repositories.CategoryRepository;
import com.atletas.catalogAtletas.repositories.ModalityRepository;
import com.atletas.catalogAtletas.repositories.SchoolRepository;
import com.atletas.catalogAtletas.resources.filters.AthleteFilter;
import com.atletas.catalogAtletas.services.exception.DataBaseException;
import com.atletas.catalogAtletas.services.exception.ResourceNotFoundException;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModalityRepository modalityRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    public AthleteDTO findById(Long id) {
        Optional<Athlete> obj = athleteRepository.findById(id);

        Athlete entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new AthleteDTO();
    }

    @Transactional
    public AthleteDTO save(AthleteDTO dto) {

        Athlete entity = new Athlete();

        copyDtoToEntity(dto, entity);

        entity = athleteRepository.save(entity);

        return new AthleteDTO();
    }

    @Transactional
    public AthleteDTO update(Long id, AthleteDTO dto) {

        try {
            Athlete entity = athleteRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = athleteRepository.save(entity);
            return new AthleteDTO();
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Id Not Found " + id);
        }

    }

    public void delete(Long id) {
        try {
            athleteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id Not Found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity Violation");
        }

    }

    private void copyDtoToEntity(AthleteDTO dto, Athlete entity) {

        entity.setCpf(dto.getCpf());
        entity.setCurriculum(dto.getCurriculum());
        entity.setDtBirth(dto.getDtBirth());
        entity.setIdentity(dto.getIdentity());
        entity.setCertBirth(dto.getCertBirth());
        entity.setName(dto.getName());
        entity.setNmFather(dto.getNmFather());
        entity.setNmMother(dto.getNmMother());
        entity.setImage(dto.getImage());
        entity.setCodAthlete(dto.getCodAthlete());
        entity.setSchool(schoolRepository.getOne(dto.getSchool().getId()));

    }

    public Page<AthleteResumedDTO> findAll(AthleteFilter filter, Pageable pageSetting) {
        return athleteRepository.findResumedPage(filter, pageSetting);
    }

}
