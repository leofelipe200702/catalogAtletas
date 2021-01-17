package com.atletas.catalogAtletas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atletas.catalogAtletas.entities.Modality;

@Repository
public interface ModalityRepository extends JpaRepository<Modality, Long>{

}
