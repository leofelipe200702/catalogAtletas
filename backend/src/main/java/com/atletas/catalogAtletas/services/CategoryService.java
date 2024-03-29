package com.atletas.catalogAtletas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atletas.catalogAtletas.dto.CategoryDTO;
import com.atletas.catalogAtletas.entities.Category;
import com.atletas.catalogAtletas.repositories.CategoryRepository;
import com.atletas.catalogAtletas.services.exception.DataBaseException;
import com.atletas.catalogAtletas.services.exception.ResourceNotFoundException;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = categoryRepository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);

		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO save(CategoryDTO dto) {

		Category entity = new Category();
		entity.setName(dto.getName());
		entity = categoryRepository.save(entity);

		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {

		try {
			Category entity = categoryRepository.getOne(id);
			entity.setName(dto.getName());
			entity = categoryRepository.save(entity);
			return new CategoryDTO(entity);
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		}

	}

	public void delete(Long id) {
		try {
			categoryRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}
		
	}

}
