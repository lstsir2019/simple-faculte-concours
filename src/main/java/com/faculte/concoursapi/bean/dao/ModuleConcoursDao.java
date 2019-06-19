/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.bean.dao;

import com.faculte.concoursapi.bean.Concours;
import com.faculte.concoursapi.bean.ModuleConcours;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BOSS
 */
@Repository
public interface ModuleConcoursDao extends JpaRepository<ModuleConcours, Long> {

    public List<ModuleConcours> findByConcoursReference(String reference);

    public ModuleConcours findByReference(String reference);

    public ModuleConcours findByReferenceAndConcoursReference(String refModule, String refConcours);
}
