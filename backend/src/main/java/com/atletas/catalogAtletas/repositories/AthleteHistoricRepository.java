package com.atletas.catalogAtletas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atletas.catalogAtletas.entities.AthleteHistoric;

@Repository
public interface AthleteHistoricRepository extends JpaRepository<AthleteHistoric, Long> {

}
