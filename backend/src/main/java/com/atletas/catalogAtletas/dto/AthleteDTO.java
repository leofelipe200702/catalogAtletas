package com.atletas.catalogAtletas.dto;

import java.io.Serializable;
import java.sql.Date;

import com.atletas.catalogAtletas.entities.Athlete;
import com.atletas.catalogAtletas.entities.Category;
import com.atletas.catalogAtletas.entities.Modality;
import com.atletas.catalogAtletas.entities.School;

public class AthleteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date dtBirth;
	private String nmFather;
	private String nmMother;
	private String curriculum;
	private String identity;
	private String cpf;
	private String imgUrl;
	private Integer year;
	private CategoryDTO category;
	private ModalityDTO modality;
	private SchoolDTO school;

	public AthleteDTO() {

	}

	public AthleteDTO(Long id, String name, Date dtBirth, String nmFather, String nmMother, String curriculum,
			String identity, String cpf, String imgUrl, Integer year) {
		this.id = id;
		this.name = name;
		this.dtBirth = dtBirth;
		this.nmFather = nmFather;
		this.nmMother = nmMother;
		this.curriculum = curriculum;
		this.identity = identity;
		this.cpf = cpf;
		this.imgUrl = imgUrl;
		this.year = year;
	}

	public AthleteDTO(Athlete entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.dtBirth = entity.getDtBirth();
		this.nmFather = entity.getNmFather();
		this.nmMother = entity.getNmMother();
		this.curriculum = entity.getCurriculum();
		this.identity = entity.getIdentity();
		this.cpf = entity.getCpf();
		this.imgUrl = entity.getImgUrl();
		this.year = entity.getYear();
	}

	public AthleteDTO(Athlete entity, Category category, Modality modality, School school) {
		this(entity);
		this.category = new CategoryDTO(category);
		this.modality = new ModalityDTO(modality);
		this.school = new SchoolDTO(school);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDtBirth() {
		return dtBirth;
	}

	public void setDtBirth(Date dtBirth) {
		this.dtBirth = dtBirth;
	}

	public String getNmFather() {
		return nmFather;
	}

	public void setNmFather(String nmFather) {
		this.nmFather = nmFather;
	}

	public String getNmMother() {
		return nmMother;
	}

	public void setNmMother(String nmMother) {
		this.nmMother = nmMother;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public ModalityDTO getModality() {
		return modality;
	}

	public void setModality(ModalityDTO modality) {
		this.modality = modality;
	}

	public SchoolDTO getSchool() {
		return school;
	}

	public void setSchool(SchoolDTO school) {
		this.school = school;
	}

}
