package com.atletas.catalogAtletas.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AthleticHistoricPk implements Serializable {

    private static final long serialVersionUID = -6616358595500291655L;

    @Column(name = "id_athlete")
    private Long athleteId;

    @Column(name = "year")
    private Integer year;

    public AthleticHistoricPk() {
        super();
    }

    public AthleticHistoricPk(Long athleteId, Integer year) {
        super();
        this.athleteId = athleteId;
        this.year = year;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
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
        result = prime * result + ((athleteId == null) ? 0 : athleteId.hashCode());
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
        AthleticHistoricPk other = (AthleticHistoricPk) obj;
        if (athleteId == null) {
            if (other.athleteId != null)
                return false;
        } else if (!athleteId.equals(other.athleteId))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AthleticHistoricPk [athleteId=" + athleteId + ", year=" + year + "]";
    }

}
