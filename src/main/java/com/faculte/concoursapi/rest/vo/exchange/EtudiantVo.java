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
public class EtudiantVo {
    
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    private String cne;
    private String napogee;
    private String etatDeust; //1:reinscr ,2:non reinscr ,3 admis
    private String email;
    private String gender;
    private FiliereVo filiereVo;
    private String password;
    private String bloquer;
    private String nbConnexionReston ;
    private String dateNaissanceVo;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateNaissanceVo() {
        return dateNaissanceVo;
    }

    public void setDateNaissanceVo(String dateNaissanceVo) {
        this.dateNaissanceVo = dateNaissanceVo;
    }

    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNapogee() {
        return napogee;
    }

    public void setNapogee(String napogee) {
        this.napogee = napogee;
    }

    public String getEtatDeust() {
        return etatDeust;
    }

    public void setEtatDeust(String etatDeust) {
        this.etatDeust = etatDeust;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public FiliereVo getFiliereVo() {
        return filiereVo;
    }

    public void setFiliereVo(FiliereVo filiereVo) {
        this.filiereVo = filiereVo;
    }

   

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBloquer() {
        return bloquer;
    }

    public void setBloquer(String bloquer) {
        this.bloquer = bloquer;
    }

    public String getNbConnexionReston() {
        return nbConnexionReston;
    }

    public void setNbConnexionReston(String nbConnexionReston) {
        this.nbConnexionReston = nbConnexionReston;
    }
    
    
    
}
