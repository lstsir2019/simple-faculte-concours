/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author BOSS
 */
@Entity
public class Concours implements Serializable {

    @OneToMany(mappedBy = "concours")
    private List<ModuleConcours> moduleConcourss;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private int anneeConcours;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateConcoursEcrit;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateConcoursOral;
    private String refFiliere;
    private int nbreplace;
    private int nbreplaceConcoursEcrit;
    private int nbreplaceConcoursOral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @JsonIgnore
    public List<ModuleConcours> getModuleConcourss() {
        return moduleConcourss;
    }

//    @JsonSetter
    public void setModuleConcourss(List<ModuleConcours> moduleConcourss) {
        this.moduleConcourss = moduleConcourss;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getAnneeConcours() {
        return anneeConcours;
    }

    public void setAnneeConcours(int anneeConcours) {
        this.anneeConcours = anneeConcours;
    }

    public Date getDateConcoursEcrit() {
        return dateConcoursEcrit;
    }

    public void setDateConcoursEcrit(Date dateConcoursEcrit) {
        this.dateConcoursEcrit = dateConcoursEcrit;
    }

    public Date getDateConcoursOral() {
        return dateConcoursOral;
    }

    public void setDateConcoursOral(Date dateConcoursOral) {
        this.dateConcoursOral = dateConcoursOral;
    }

    public int getNbreplace() {
        return nbreplace;
    }

    public void setNbreplace(int nbreplace) {
        this.nbreplace = nbreplace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getRefFiliere() {
        return refFiliere;
    }

    public void setRefFiliere(String refFiliere) {
        this.refFiliere = refFiliere;
    }

    public int getNbreplaceConcoursEcrit() {
        return nbreplaceConcoursEcrit;
    }

    public void setNbreplaceConcoursEcrit(int nbreplaceConcoursEcrit) {
        this.nbreplaceConcoursEcrit = nbreplaceConcoursEcrit;
    }

    public int getNbreplaceConcoursOral() {
        return nbreplaceConcoursOral;
    }

    public void setNbreplaceConcoursOral(int nbreplaceConcoursOral) {
        this.nbreplaceConcoursOral = nbreplaceConcoursOral;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concours)) {
            return false;
        }
        Concours other = (Concours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.faculte.concoursapi.bean.Concours[ id=" + id + " ]";
    }

}
