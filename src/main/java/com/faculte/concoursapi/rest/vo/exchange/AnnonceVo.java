/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.vo.exchange;

import java.util.List;

/**
 *
 * @author admin
 */
public class AnnonceVo {
    
    private Long id;
    private String title;
    private String description;
    private FiliereVo filiereVos;
    private String dateCreation;
    private TypeAnnonceVo typeAnnonceVo;
    private List<DocumentVo> documentVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FiliereVo getFiliereVos() {
        return filiereVos;
    }

    public void setFiliereVos(FiliereVo filiereVos) {
        this.filiereVos = filiereVos;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeAnnonceVo getTypeAnnonceVo() {
        return typeAnnonceVo;
    }

    public void setTypeAnnonceVo(TypeAnnonceVo typeAnnonceVo) {
        this.typeAnnonceVo = typeAnnonceVo;
    }

    public List<DocumentVo> getDocumentVo() {
        return documentVo;
    }

    public void setDocumentVo(List<DocumentVo> documentVo) {
        this.documentVo = documentVo;
    }

    
    
    
}
