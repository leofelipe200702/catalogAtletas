package com.atletas.catalogAtletas.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_athlete")
public class Athlete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codAthlete;
    private String name;
    private LocalDate dtBirth;
    private String nmFather;
    private String nmMother;
    @Column(columnDefinition = "TEXT")
    private String curriculum;
    private String identity;
    private String certBirth;
    private String cpf;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AthleteHistoric> historical = new ArrayList<>();

    @Lob
    private String image;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "tb_athlete_modality", joinColumns = {@JoinColumn(name = "id_athlete")}, inverseJoinColumns = {@JoinColumn(name = "id_modality")})
    private List<Modality> modalities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_school", nullable = false)
    private School school;

    public Athlete() {
        super();
    }

    public Athlete(Long id, String codAthlete, String name, LocalDate dtBirth, String nmFather, String nmMother, String curriculum,
            String identity, String certBirth, String cpf, List<AthleteHistoric> historical, String image, List<Modality> modalities,
            School school) {
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
        this.historical = historical;
        this.image = image;
        this.modalities = modalities;
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

    public List<AthleteHistoric> getHistorical() {
        return historical;
    }

    public void setHistorical(List<AthleteHistoric> historical) {
        this.historical = historical;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Modality> getModalities() {
        return modalities;
    }

    public void setModalities(List<Modality> modalities) {
        this.modalities = modalities;
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
        result = prime * result + ((curriculum == null) ? 0 : curriculum.hashCode());
        result = prime * result + ((dtBirth == null) ? 0 : dtBirth.hashCode());
        result = prime * result + ((historical == null) ? 0 : historical.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((identity == null) ? 0 : identity.hashCode());
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + ((modalities == null) ? 0 : modalities.hashCode());
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
        Athlete other = (Athlete) obj;
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
        if (curriculum == null) {
            if (other.curriculum != null)
                return false;
        } else if (!curriculum.equals(other.curriculum))
            return false;
        if (dtBirth == null) {
            if (other.dtBirth != null)
                return false;
        } else if (!dtBirth.equals(other.dtBirth))
            return false;
        if (historical == null) {
            if (other.historical != null)
                return false;
        } else if (!historical.equals(other.historical))
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
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (modalities == null) {
            if (other.modalities != null)
                return false;
        } else if (!modalities.equals(other.modalities))
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
        return "Athlete [id=" + id + ", codAthlete=" + codAthlete + ", name=" + name + ", dtBirth=" + dtBirth + ", nmFather=" + nmFather
                + ", nmMother=" + nmMother + ", curriculum=" + curriculum + ", identity=" + identity + ", certBirth=" + certBirth + ", cpf="
                + cpf + ", historical=" + historical + ", image=" + image + ", modalities=" + modalities + ", school=" + school + "]";
    }

}
