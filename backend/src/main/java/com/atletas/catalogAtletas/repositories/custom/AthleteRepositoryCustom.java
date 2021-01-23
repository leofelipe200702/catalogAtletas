package com.atletas.catalogAtletas.repositories.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.atletas.catalogAtletas.dto.AthleteResumedDTO;
import com.atletas.catalogAtletas.resources.filters.AthleteFilter;

public interface AthleteRepositoryCustom {
    Page<AthleteResumedDTO> findResumedPage(AthleteFilter filter, Pageable pageSettings);
}
