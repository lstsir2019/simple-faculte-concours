/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.vo;

import java.util.List;

/**
 *
 * @author BOSS
 */
public class ConcoursVo {

    private Long id;
    private String reference;
    private String anneeConcours;
    private String nbreplace;
    private List<ModuleConcoursVo> moduleConcoursVo;
    private String refFiliere;
    private String dateConcoursEcrit;
    private String dateConcoursOral;
    private String nbreplaceConcoursEcrit;
    private String nbreplaceConcoursOral;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAnneeConcours() {
        return anneeConcours;
    }

    public void setAnneeConcours(String anneeConcours) {
        this.anneeConcours = anneeConcours;
    }

    public String getNbreplace() {
        return nbreplace;
    }

    public void setNbreplace(String nbreplace) {
        this.nbreplace = nbreplace;
    }

    public String getDateConcoursEcrit() {
        return dateConcoursEcrit;
    }

    public void setDateConcoursEcrit(String dateConcoursEcrit) {
        this.dateConcoursEcrit = dateConcoursEcrit;
    }

    public String getDateConcoursOral() {
        return dateConcoursOral;
    }

    public void setDateConcoursOral(String dateConcoursOral) {
        this.dateConcoursOral = dateConcoursOral;
    }

    public List<ModuleConcoursVo> getModuleConcoursVo() {
        return moduleConcoursVo;
    }

    public void setModuleConcoursVo(List<ModuleConcoursVo> moduleConcoursVo) {
        this.moduleConcoursVo = moduleConcoursVo;
    }

    public String getRefFiliere() {
        return refFiliere;
    }

    public void setRefFiliere(String refFiliere) {
        this.refFiliere = refFiliere;
    }

    public String getNbreplaceConcoursEcrit() {
        return nbreplaceConcoursEcrit;
    }

    public void setNbreplaceConcoursEcrit(String nbreplaceConcoursEcrit) {
        this.nbreplaceConcoursEcrit = nbreplaceConcoursEcrit;
    }

    public String getNbreplaceConcoursOral() {
        return nbreplaceConcoursOral;
    }

    public void setNbreplaceConcoursOral(String nbreplaceConcoursOral) {
        this.nbreplaceConcoursOral = nbreplaceConcoursOral;
    }

}
