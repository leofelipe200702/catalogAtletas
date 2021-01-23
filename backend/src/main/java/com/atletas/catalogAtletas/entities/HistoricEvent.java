package com.atletas.catalogAtletas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_historic_event")
public class HistoricEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolName;

    private String modalityName;

    private String categoryName;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modalityName == null) ? 0 : modalityName.hashCode());
        result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
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
        HistoricEvent other = (HistoricEvent) obj;
        if (categoryName == null) {
            if (other.categoryName != null)
                return false;
        } else if (!categoryName.equals(other.categoryName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (modalityName == null) {
            if (other.modalityName != null)
                return false;
        } else if (!modalityName.equals(other.modalityName))
            return false;
        if (schoolName == null) {
            if (other.schoolName != null)
                return false;
        } else if (!schoolName.equals(other.schoolName))
            return false;
        return true;
    }

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

}
