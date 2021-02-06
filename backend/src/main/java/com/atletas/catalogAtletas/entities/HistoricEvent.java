package com.atletas.catalogAtletas.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_historic_event")
public class HistoricEvent implements Serializable {

    private static final long serialVersionUID = 5798053972305265800L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolName;

    private String modalityName;

    private String categoryName;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_athlete", referencedColumnName = "id_athlete")
    @JoinColumn(name = "year", referencedColumnName = "year")
    private AthleteHistoric historic;

    public HistoricEvent() {
        super();
    }

    public HistoricEvent(Long id, String schoolName, String modalityName, String categoryName, AthleteHistoric historic) {
        super();
        this.id = id;
        this.schoolName = schoolName;
        this.modalityName = modalityName;
        this.categoryName = categoryName;
        this.historic = historic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getModalityName() {
        return modalityName;
    }

    public void setModalityName(String modalityName) {
        this.modalityName = modalityName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public AthleteHistoric getHistoric() {
        return historic;
    }

    public void setHistoric(AthleteHistoric historic) {
        this.historic = historic;
    }

    @Override
    public String toString() {
        return "HistoricEvent [id=" + id + ", schoolName=" + schoolName + ", modalityName=" + modalityName + ", categoryName="
                + categoryName + ", historic=" + historic + "]";
    }

}
