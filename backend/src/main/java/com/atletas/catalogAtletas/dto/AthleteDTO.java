package com.atletas.catalogAtletas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.atletas.catalogAtletas.entities.Athlete;
import com.atletas.catalogAtletas.entities.School;

public class AthleteDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;
    private String codAthlete;
    private String name;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dtBirth;
    private String nmFather;
    private String nmMother;
    private String curriculum;
    private String identity;
    private String cpf;
    private SchoolDTO school;
    private String image;
    private String certBirth;

    public AthleteDTO() {

    }

    public AthleteDTO(Long id, String codAthlete, String name, LocalDate dtBirth, String nmFather, String nmMother,
            String curriculum, String identity, String cpf, String image, String certBirth) {
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
        this.image = image;
    }

    public AthleteDTO(Athlete entity) {
        this.id = entity.getId();
        this.codAthlete = entity.getCodAthlete();
        this.name = entity.getName();
        this.dtBirth = entity.getDtBirth();
        this.nmFather = entity.getNmFather();
        this.nmMother = entity.getNmMother();
        this.curriculum = entity.getCurriculum();
        this.identity = entity.getIdentity();
        this.certBirth = entity.getCertBirth();
        this.cpf = entity.getCpf();
        this.image = entity.getImage();
    }

    public AthleteDTO(Athlete entity,School school) {
        this(entity);
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

    public LocalDate getDtBirth() {
        return dtBirth;
    }

    public void setDtBirth(LocalDate dtBirth) {
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

    public String getCertBirth() {
        return certBirth;
    }

    public void setCertBirth(String certBirth) {
        this.certBirth = certBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }   

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
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
		AthleteDTO other = (AthleteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    

}
