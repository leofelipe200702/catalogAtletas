package com.atletas.catalogAtletas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atletas.catalogAtletas.entities.AthleteHistoric;
import com.atletas.catalogAtletas.entities.AthleticHistoricPk;

@Repository
public interface AthleteHistoricRepository extends JpaRepository<AthleteHistoric, AthleticHistoricPk> {	
	Optional<AthleteHistoric> findByPk(AthleticHistoricPk pk);	

}
