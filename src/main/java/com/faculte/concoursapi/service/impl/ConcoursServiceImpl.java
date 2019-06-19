/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.service.impl;

import com.faculte.concoursapi.bean.Concours;
import com.faculte.concoursapi.bean.ModuleConcours;
import com.faculte.concoursapi.bean.dao.ConcoursDao;
import com.faculte.concoursapi.common.util.SearchUtil;
import com.faculte.concoursapi.rest.proxy.FiliereProxy;
import com.faculte.concoursapi.rest.vo.exchange.FiliereVo;
import com.faculte.concoursapi.service.CoefModuleConcoursService;
import com.faculte.concoursapi.service.ConcoursService;
import com.faculte.concoursapi.service.ModuleConcoursService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BOSS
 */
@Service
public class ConcoursServiceImpl implements ConcoursService {

    @Autowired
    private FiliereProxy filiereProxy;

    @Autowired
    private ConcoursDao concoursDao;

    @Autowired
    private CoefModuleConcoursService coefModuleConcoursService;

    @Autowired
    private ModuleConcoursService moduleConcoursService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Concours findByReference(String reference) {
        return concoursDao.findByReference(reference);
    }

    @Override
    public Concours findByRefFiliere(String refFiliere) {
        return concoursDao.findByRefFiliere(refFiliere);
    }

    @Override
    public List<Concours> findAll() {
        return concoursDao.findAll();
    }

    @Override
    public int DeleteConcours(Concours concours) {

        Concours c = concoursDao.findByReference(concours.getReference());
        if (c == null) {
            System.out.println("khawi");
            return -1;
        } else {
            List<ModuleConcours> moduleConcourss = moduleConcoursService.findByConcoursReference(c.getReference());
            for (ModuleConcours moduleConcours : moduleConcourss) {
                moduleConcoursService.DeleteModuleConcours(moduleConcours);
            }
            concoursDao.delete(c);
            return 1;
        }
    }

    @Override
    public int saveConcoursComplet(Concours concours) {

        Concours c = findByReference(concours.getReference());
        if (c != null) {
            return -1;
        } else if (filiereProxy.findByAbreviation(concours.getRefFiliere()) == null) {
            return -2;
        } else {
            concoursDao.save(concours);
            moduleConcoursService.saveModuleConcours(concours);
        }
        return 1;
    }

    @Override
    public List<Concours> findByAnneeConcours(int anneeConcours) {
        return this.concoursDao.findByAnneeConcours(anneeConcours);
    }

    @Override
    public List<Concours> findByCreteria(String reference, String refFiliere, String anneeConcours) {
        return entityManager.createQuery(constructQuery(reference, refFiliere, anneeConcours)).getResultList();
    }

    private String constructQuery(String reference, String refFiliere, String anneeConcours) {
        String query = "SELECT c FROM Concours c where 1=1";
        query += SearchUtil.addConstraint("c", "reference", "=", reference);
        query += SearchUtil.addConstraint("c", "refFiliere", "LIKE", refFiliere);
        query += SearchUtil.addConstraint("c", "anneeConcours", "LIKE", anneeConcours);
        return query;
    }

    @Override
    public int updateConcours(Concours concours) {
        Concours c = findByReference(concours.getReference());
        if (c == null) {
            return -1;
        } else {
            c.setDateConcoursEcrit(concours.getDateConcoursEcrit());
            c.setDateConcoursOral(concours.getDateConcoursOral());
            c.setNbreplace(concours.getNbreplace());
            c.setNbreplaceConcoursEcrit(concours.getNbreplaceConcoursEcrit());
            c.setNbreplaceConcoursOral(concours.getNbreplaceConcoursOral());
//            for (ModuleConcours moduleConcours : concours.getModuleConcourss()) {
//                moduleConcoursService.updateModuleConcours(moduleConcours);
//                moduleConcoursService.saveModuleConcours(concours);
        }
        concoursDao.save(c);
        return 1;
    }

    public ConcoursDao getConcoursDao() {
        return concoursDao;
    }

    public void setConcoursDao(ConcoursDao concoursDao) {
        this.concoursDao = concoursDao;
    }

    public CoefModuleConcoursService getCoefModuleConcoursService() {
        return coefModuleConcoursService;
    }

    public void setCoefModuleConcoursService(CoefModuleConcoursService coefModuleConcoursService) {
        this.coefModuleConcoursService = coefModuleConcoursService;
    }

    public ModuleConcoursService getModuleConcoursService() {
        return moduleConcoursService;
    }

    public void setModuleConcoursService(ModuleConcoursService moduleConcoursService) {
        this.moduleConcoursService = moduleConcoursService;
    }

    public FiliereProxy getFiliereProxy() {
        return filiereProxy;
    }

    public void setFiliereProxy(FiliereProxy filiereProxy) {
        this.filiereProxy = filiereProxy;
    }

    @Override
    public int AddModuletoConcours(String reference, ModuleConcours moduleConcours) {
        Concours c = concoursDao.findByReference(reference);
        System.out.println("c = " + c);
        if (c == null) {
            return -1;
        } else {
            for (ModuleConcours moduleConcours1 : c.getModuleConcourss()) {
                System.out.println("moduleConcours1 = " + moduleConcours1);
                System.out.println("moduleConcours2 = " + moduleConcours);
                if (moduleConcours1 == moduleConcours) {
                    return -2;
                } else {
                    moduleConcoursService.saveModuleConcours(c);
                    concoursDao.save(c);

//                    return 1;
                }
            }
            return 1;
        }

    }

    @Override
    public List<FiliereVo> findfiliereByTypeFiliere(int type) {
        return filiereProxy.findByTypeFiliere(type);
    }
}
