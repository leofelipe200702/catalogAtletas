package com.atletas.catalogAtletas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public HistoricEvent() {
        super();
    }

    public HistoricEvent(Long id, String schoolName, String modalityName, String categoryName) {
        super();
        this.id = id;
        this.schoolName = schoolName;
        this.modalityName = modalityName;
        this.categoryName = categoryName;
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

    @Override
    public String toString() {
        return "HistoricEvent [id=" + id + ", schoolName=" + schoolName + ", modalityName=" + modalityName + ", categoryName="
                + categoryName + "]";
    }

}
