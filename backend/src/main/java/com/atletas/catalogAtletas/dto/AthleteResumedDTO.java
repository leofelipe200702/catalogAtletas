package com.atletas.catalogAtletas.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.atletas.catalogAtletas.entities.School;

/**
 * DTO resumido para paginação (Utilizar apenas para externalização)
 * 
 * @author viniciosarodrigues
 *
 */
public class AthleteResumedDTO implements Serializable {

    private static final long serialVersionUID = -5430761884602664341L;

    private Long id;
    private String codAthlete;
    private String name;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dtBirth;
    private String nmFather;
    private String nmMother;
    private String identity;
    private String certBirth;
    private String cpf;
    private School school;

    public AthleteResumedDTO(Long id, String codAthlete, String name, LocalDate dtBirth, String nmFather, String nmMother, String identity,
            String certBirth, String cpf,School school) {
        super();
        this.id = id;
        this.codAthlete = codAthlete;
        this.name = name;
        this.dtBirth = dtBirth;
        this.nmFather = nmFather;
        this.nmMother = nmMother;
        this.identity = identity;
        this.certBirth = certBirth;
        this.cpf = cpf;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodAthlete() {
        return codAthlete;
    }

    public void setCodAthlete(String codAthlete) {
        this.codAthlete = codAthlete;
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

    public String getCertBirth() {
        return certBirth;
    }

    public void setCertBirth(String certBirth) {
        this.certBirth = certBirth;
    }
    
    public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certBirth == null) ? 0 : certBirth.hashCode());
		result = prime * result + ((codAthlete == null) ? 0 : codAthlete.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dtBirth == null) ? 0 : dtBirth.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nmFather == null) ? 0 : nmFather.hashCode());
		result = prime * result + ((nmMother == null) ? 0 : nmMother.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
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
		AthleteResumedDTO other = (AthleteResumedDTO) obj;
		if (certBirth == null) {
			if (other.certBirth != null)
				return false;
		} else if (!certBirth.equals(other.certBirth))
			return false;
		if (codAthlete == null) {
			if (other.codAthlete != null)
				return false;
		} else if (!codAthlete.equals(other.codAthlete))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dtBirth == null) {
			if (other.dtBirth != null)
				return false;
		} else if (!dtBirth.equals(other.dtBirth))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nmFather == null) {
			if (other.nmFather != null)
				return false;
		} else if (!nmFather.equals(other.nmFather))
			return false;
		if (nmMother == null) {
			if (other.nmMother != null)
				return false;
		} else if (!nmMother.equals(other.nmMother))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AthleteResumedDTO [id=" + id + ", codAthlete=" + codAthlete + ", name=" + name + ", dtBirth=" + dtBirth
				+ ", nmFather=" + nmFather + ", nmMother=" + nmMother + ", identity=" + identity + ", certBirth="
				+ certBirth + ", cpf=" + cpf + ", school=" + school + "]";
	}
	
	


}
