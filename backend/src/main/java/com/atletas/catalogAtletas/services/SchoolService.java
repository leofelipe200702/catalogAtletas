package com.atletas.catalogAtletas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atletas.catalogAtletas.dto.SchoolDTO;
import com.atletas.catalogAtletas.entities.School;
import com.atletas.catalogAtletas.repositories.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	@Transactional(readOnly = true)
	public List<SchoolDTO> findAll() {
		List<School> list = schoolRepository.findAll();
		return list.stream().map(x -> new SchoolDTO(x)).collect(Collectors.toList());
	}

}
