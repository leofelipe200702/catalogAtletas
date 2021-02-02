package com.atletas.catalogAtletas.dto;

import java.io.Serializable;

import com.atletas.catalogAtletas.entities.AthleteHistoric;

public class AthleteHistoricDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id_athlete;
	private Integer year;	
	
	public AthleteHistoricDTO(Long id_athlete, Integer year) {
		this.id_athlete = id_athlete;
		this.year = year;
	}
	
	public AthleteHistoricDTO(AthleteHistoric entity) {
		this.id_athlete = entity.getPk().getAthleteId();
		this.year = entity.getPk().getYear();
	}
	
	public Long getId_athlete() {
		return id_athlete;
	}

	public void setId_athlete(Long id_athlete) {
		this.id_athlete = id_athlete;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_athlete == null) ? 0 : id_athlete.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		AthleteHistoricDTO other = (AthleteHistoricDTO) obj;
		if (id_athlete == null) {
			if (other.id_athlete != null)
				return false;
		} else if (!id_athlete.equals(other.id_athlete))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}	

}
