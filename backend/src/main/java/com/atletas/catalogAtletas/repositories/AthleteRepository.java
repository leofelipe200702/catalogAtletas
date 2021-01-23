package com.atletas.catalogAtletas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atletas.catalogAtletas.entities.Athlete;
import com.atletas.catalogAtletas.repositories.custom.AthleteRepositoryCustom;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long>, AthleteRepositoryCustom {

}
