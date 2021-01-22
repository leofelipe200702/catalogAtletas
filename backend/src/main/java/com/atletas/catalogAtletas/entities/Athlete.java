package com.atletas.catalogAtletas.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_athlete")
public class Athlete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codAthlete;
	private String name;
	private Date dtBirth;
	private String nmFather;
	private String nmMother;
	@Column(columnDefinition = "TEXT")
	private String curriculum;
	private String identity;
	private String certBirth;
	private String cpf;
	private Integer year;
	@Lob
	private String image;

	@ManyToOne
	@JoinColumn(name = "id_category", nullable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "id_modality", nullable = false)
	private Modality modality;

	@ManyToOne
	@JoinColumn(name = "id_school", nullable = false)
	private School school;

	public Athlete() {

	}

	public Athlete(Long id, String codAthlete, String name, Date dtBirth, String nmFather, String nmMother,
			String curriculum, String identity, String cpf, Integer year, String image, Category category,
			Modality modality, School school, String certBirth) {
		super();
		this.id = id;
		this.codAthlete = codAthlete;
		this.name = name;
		this.dtBirth = dtBirth;
		this.nmFather = nmFather;
		this.nmMother = nmMother;
		this.curriculum = curriculum;
		this.identity = identity;
		this.certBirth = certBirth;
		this.cpf = cpf;
		this.year = year;
		this.image = image;
		this.category = category;
		this.modality = modality;
		this.school = school;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Modality getModality() {
		return modality;
	}

	public void setModality(Modality modality) {
		this.modality = modality;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCodAthlete() {
		return codAthlete;
	}

	public void setCodAthlete(String codAthlete) {
		this.codAthlete = codAthlete;
	}

	public String getCertBirth() {
		return certBirth;
	}

	public void setCertBirth(String certBirth) {
		this.certBirth = certBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Athlete other = (Athlete) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
