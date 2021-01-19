package com.atletas.catalogAtletas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atletas.catalogAtletas.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
