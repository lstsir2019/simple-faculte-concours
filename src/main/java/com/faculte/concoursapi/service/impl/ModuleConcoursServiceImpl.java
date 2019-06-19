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
import com.faculte.concoursapi.bean.dao.ModuleConcoursDao;
import com.faculte.concoursapi.service.CoefModuleConcoursService;
import com.faculte.concoursapi.service.ModuleConcoursService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BOSS
 */
@Service
public class ModuleConcoursServiceImpl implements ModuleConcoursService {

    @Autowired
    private ModuleConcoursDao moduleConcoursDao;
    @Autowired
    private CoefModuleConcoursService coefModuleConcoursService;
    @Autowired
    private CoefModuleConcoursDao coefModuleConcoursDao;

    @Override
    public List<ModuleConcours> findByConcoursReference(String reference) {
        return moduleConcoursDao.findByConcoursReference(reference);
    }

    @Override
    public ModuleConcours findByReference(String reference) {
        return moduleConcoursDao.findByReference(reference);
    }

    @Override
    public int DeleteModuleConcours(ModuleConcours moduleConcours) {
        if (moduleConcours == null) {
            System.out.println("hna");
            return -1;
        } else {
            System.out.println("lhih");
            moduleConcoursDao.delete(moduleConcours);
        }
        return 1;
    }

    public ModuleConcoursDao getModuleConcoursDao() {
        return moduleConcoursDao;
    }

    public void setModuleConcoursDao(ModuleConcoursDao moduleConcoursDao) {
        this.moduleConcoursDao = moduleConcoursDao;
    }

    @Override
    public int saveModuleConcours(Concours concours) {
        for (ModuleConcours moduleConcours : concours.getModuleConcourss()) {
            moduleConcours.setConcours(concours);
            coefModuleConcoursService.saveCoefModuleConcours(moduleConcours);

            moduleConcoursDao.save(moduleConcours);
        }
        return 1;
    }

    @Override
    public int DeleteModuleConcoursById(Long id) {
        boolean exist = moduleConcoursDao.existsById(id);
        if (!exist) {
            return -1;
        } else {
            ModuleConcours mc = moduleConcoursDao.getOne(id);

            moduleConcoursDao.delete(mc);
            return 1;
        }
    }

    public CoefModuleConcoursService getCoefModuleConcoursService() {
        return coefModuleConcoursService;
    }

    public void setCoefModuleConcoursService(CoefModuleConcoursService coefModuleConcoursService) {
        this.coefModuleConcoursService = coefModuleConcoursService;
    }

    @Override
    public ModuleConcours findById(Long id) {
        return this.moduleConcoursDao.getOne(id);
    }

    @Override
    public ModuleConcours findByReferenceAndConcoursReference(String refModule, String refConcours) {
        return moduleConcoursDao.findByReferenceAndConcoursReference(refModule, refConcours);
    }

    @Override
    public int updateModuleConcours(ModuleConcours moduleConcours) {
        ModuleConcours mc = findById(moduleConcours.getId());
        if (mc == null) {
            return -1;
        } else {
            CoefModuleConcours c = mc.getCoefModuleConcours();
           System.out.println(c.getRefFiliere());
            c.setCoef(moduleConcours.getCoefModuleConcours().getCoef());
            coefModuleConcoursDao.save(c);
    //        coefModuleConcoursService.updateCoef(c);
            moduleConcoursDao.save(mc);
            return 1;
        }

    }

}
