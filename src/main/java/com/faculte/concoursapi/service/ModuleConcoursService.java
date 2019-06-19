/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.service;

import com.faculte.concoursapi.bean.Concours;
import com.faculte.concoursapi.bean.ModuleConcours;
import java.util.List;

/**
 *
 * @author BOSS
 */
public interface ModuleConcoursService {

    public List<ModuleConcours> findByConcoursReference(String reference);

    public ModuleConcours findByReference(String reference);

    public ModuleConcours findById(Long id);

    public int saveModuleConcours(Concours concours);

    public int updateModuleConcours(ModuleConcours moduleConcours);

    public int DeleteModuleConcours(ModuleConcours moduleConcours);

    public int DeleteModuleConcoursById(Long id);

    public ModuleConcours findByReferenceAndConcoursReference(String refModule, String refConcours);
}
