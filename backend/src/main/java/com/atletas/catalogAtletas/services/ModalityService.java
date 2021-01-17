package com.atletas.catalogAtletas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atletas.catalogAtletas.dto.ModalityDTO;
import com.atletas.catalogAtletas.entities.Modality;
import com.atletas.catalogAtletas.repositories.ModalityRepository;

@Service
public class ModalityService {

	@Autowired
	private ModalityRepository modalityRepository;

	@Transactional(readOnly = true)
	public List<ModalityDTO> findAll() {
		List<Modality> list = modalityRepository.findAll();
		return list.stream().map(x -> new ModalityDTO(x)).collect(Collectors.toList());
	}

}
