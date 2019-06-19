/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.vo.exchange;

/**
 *
 * @author admin
 */
public class ModuleVo {

    private Long id;
    private String libelle;
    private SemestreVo semestreVo;
    private String cinPersonnel;
    private String typePersonnel;
    private FiliereVo filiereVo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePersonnel() {
        return typePersonnel;
    }

    public void setTypePersonnel(String typePersonnel) {
        this.typePersonnel = typePersonnel;
    }

    public FiliereVo getFiliereVo() {
        return filiereVo;
    }

    public void setFiliereVo(FiliereVo filiereVo) {
        this.filiereVo = filiereVo;
    }

    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public SemestreVo getSemestreVo() {
        return semestreVo;
    }

    public void setSemestreVo(SemestreVo semestreVo) {
        this.semestreVo = semestreVo;
    }

   

    

   

    public String getCinPersonnel() {
        return cinPersonnel;
    }

    public void setCinPersonnel(String cinPersonnel) {
        this.cinPersonnel = cinPersonnel;
    }

    
    
    

}
