package com.atletas.catalogAtletas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atletas.catalogAtletas.dto.AthleteDTO;
import com.atletas.catalogAtletas.entities.Athlete;
import com.atletas.catalogAtletas.repositories.AthleteRepository;
import com.atletas.catalogAtletas.repositories.CategoryRepository;
import com.atletas.catalogAtletas.repositories.ModalityRepository;
import com.atletas.catalogAtletas.repositories.SchoolRepository;

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
	public List<AthleteDTO> findAll() {
		List<Athlete> list = athleteRepository.findAll();
				
		return list.stream().map(x -> new AthleteDTO(x,x.getCategory(),x.getModality(),x.getSchool())).collect(Collectors.toList());
	}

	@Transactional
	public AthleteDTO save(AthleteDTO dto) {

		Athlete entity = new Athlete();

		copyDtoToEntity(dto, entity);

		entity = athleteRepository.save(entity);

		return new AthleteDTO(entity,entity.getCategory(),entity.getModality(),entity.getSchool());
	}

	private void copyDtoToEntity(AthleteDTO dto, Athlete entity) {

		entity.setCpf(dto.getCpf());
		entity.setCurriculum(dto.getCurriculum());
		entity.setDtBirth(dto.getDtBirth());
		entity.setIdentity(dto.getIdentity());
		entity.setImgUrl(dto.getImgUrl());
		entity.setName(dto.getName());
		entity.setNmFather(dto.getNmFather());
		entity.setNmMother(dto.getNmMother());
		entity.setYear(dto.getYear());
		entity.setModality(modalityRepository.getOne(dto.getModality().getId()));
		entity.setCategory(categoryRepository.getOne(dto.getCategory().getId()));
		entity.setSchool(schoolRepository.getOne(dto.getSchool().getId()));

	}

}
