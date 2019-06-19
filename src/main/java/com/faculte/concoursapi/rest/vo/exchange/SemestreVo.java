/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.vo.exchange;

import java.util.List;

/**
 *
 * @author Naoufal's pc
 */
public class SemestreVo {
    
    private Long id;
    private String libelle;
    private List<ModuleVo> moduleVos;
    private FiliereVo filiereVo;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ModuleVo> getModuleVos() {
        return moduleVos;
    }

    public void setModuleVos(List<ModuleVo> moduleVos) {
        this.moduleVos = moduleVos;
    }

   
    
    
}
