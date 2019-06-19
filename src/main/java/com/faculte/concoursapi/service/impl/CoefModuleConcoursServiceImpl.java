/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.service.impl;

import com.faculte.concoursapi.bean.CoefModuleConcours;
import com.faculte.concoursapi.bean.Concours;
import com.faculte.concoursapi.bean.ModuleConcours;
import com.faculte.concoursapi.bean.dao.CoefModuleConcoursDao;
import com.faculte.concoursapi.service.CoefModuleConcoursService;
import com.faculte.concoursapi.service.ConcoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BOSS
 */
@Service
public class CoefModuleConcoursServiceImpl implements CoefModuleConcoursService {

    @Autowired
    private CoefModuleConcoursDao coefModuleConcoursDao;

    @Autowired
    private ConcoursService concoursService;

    @Override
    public CoefModuleConcours findByCoef(Double coef) {
        return coefModuleConcoursDao.findByCoef(coef);
    }

    @Override
    public int saveCoefModuleConcours(ModuleConcours moduleConcours) {

        CoefModuleConcours coefModuleConcours = moduleConcours.getCoefModuleConcours();
        coefModuleConcours.setRefFiliere(moduleConcours.getConcours().getRefFiliere());
        coefModuleConcoursDao.save(coefModuleConcours);
        return 1;
    }

    @Override
    public double totalCoef(String refConcours) {
        Concours concours = concoursService.findByReference(refConcours);
        double somme = 0;
        for (ModuleConcours moduleConcours : concours.getModuleConcourss()) {
            somme += moduleConcours.getCoefModuleConcours().getCoef();
        }
        return somme;
    }

    public CoefModuleConcoursDao getCoefModuleConcoursDao() {
        return coefModuleConcoursDao;
    }

    public void setCoefModuleConcoursDao(CoefModuleConcoursDao coefModuleConcoursDao) {
        this.coefModuleConcoursDao = coefModuleConcoursDao;
    }

    @Override
    public CoefModuleConcours findCoefById(Long id) {
        return this.coefModuleConcoursDao.getOne(id);
    }

    @Override
    public int updateCoef(CoefModuleConcours cmc) {
        CoefModuleConcours coef = coefModuleConcoursDao.getOne(cmc.getId());
        if (coef == null) {
            return -1;
        } else {
            coef.setCoef(cmc.getCoef());
            coefModuleConcoursDao.save(cmc);
            return 1;
        }
    }
}
