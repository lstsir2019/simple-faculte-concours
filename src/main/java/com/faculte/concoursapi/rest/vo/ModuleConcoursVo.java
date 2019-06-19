/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.vo;

/**
 *
 * @author BOSS
 */
public class ModuleConcoursVo {

    private CoefModuleConcoursVo coefModuleConcoursVo;
    private Long id;
    private String reference;
    private ConcoursVo concoursVo;

    public CoefModuleConcoursVo getCoefModuleConcoursVo() {
        return coefModuleConcoursVo;
    }

    public void setCoefModuleConcoursVo(CoefModuleConcoursVo coefModuleConcoursVo) {
        this.coefModuleConcoursVo = coefModuleConcoursVo;
    }

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

    public ConcoursVo getConcoursVo() {
        return concoursVo;
    }

    public void setConcoursVo(ConcoursVo concoursVo) {
        this.concoursVo = concoursVo;
    }

}
