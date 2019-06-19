/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.service;

import com.faculte.concoursapi.bean.CoefModuleConcours;
import com.faculte.concoursapi.bean.ModuleConcours;

/**
 *
 * @author BOSS
 */
public interface CoefModuleConcoursService {

    public CoefModuleConcours findByCoef(Double coef);

    public int saveCoefModuleConcours(ModuleConcours moduleConcours);

    public double totalCoef(String refConcours);

    public CoefModuleConcours findCoefById(Long id);

    public int updateCoef(CoefModuleConcours cmc);
}
