package com.atletas.catalogAtletas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_athletic_historic")
public class AthleteHistoric implements Serializable {

    private static final long serialVersionUID = -2173546013132048211L;

    @EmbeddedId
    private AthleticHistoricPk pk;

    @MapsId("athleteId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_athlete")
    private Athlete athlete;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "historic")
    private List<HistoricEvent> events = new ArrayList<>();

    public AthleticHistoricPk getPk() {
        return pk;
    }

    public void setPk(AthleticHistoricPk pk) {
        this.pk = pk;
    }

    public List<HistoricEvent> getEvents() {
        return events;
    }

    public void setEvents(List<HistoricEvent> events) {
        this.events = events;
    }

    public AthleteHistoric(AthleticHistoricPk pk, List<HistoricEvent> events) {
        super();
        this.pk = pk;
        this.events = events;
    }

    public AthleteHistoric() {
        super();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((events == null) ? 0 : events.hashCode());
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
        AthleteHistoric other = (AthleteHistoric) obj;
        if (events == null) {
            if (other.events != null)
                return false;
        } else if (!events.equals(other.events))
            return false;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AthleteHistoric [pk=" + pk + ", events=" + events + "]";
    }

}
