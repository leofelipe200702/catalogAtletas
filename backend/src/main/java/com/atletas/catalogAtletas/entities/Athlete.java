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

    private static final long serialVersionUID = 1048973653487198741L;

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
    public String toString() {
        return "Athlete [id=" + id + ", codAthlete=" + codAthlete + ", name=" + name + ", dtBirth=" + dtBirth + ", nmFather=" + nmFather
                + ", nmMother=" + nmMother + ", curriculum=" + curriculum + ", identity=" + identity + ", certBirth=" + certBirth + ", cpf="
                + cpf + ", historical=" + historical + ", image=" + image + ", modalities=" + modalities + ", school=" + school + "]";
    }

}
