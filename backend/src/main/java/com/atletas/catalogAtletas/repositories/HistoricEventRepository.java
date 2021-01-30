package com.atletas.catalogAtletas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atletas.catalogAtletas.entities.HistoricEvent;

@Repository
public interface HistoricEventRepository extends JpaRepository<HistoricEvent, Long> {

}
