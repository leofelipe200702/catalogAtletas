package com.atletas.catalogAtletas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atletas.catalogAtletas.entities.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
