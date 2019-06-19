/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.bean.dao;

import com.faculte.concoursapi.bean.CoefModuleConcours;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BOSS
 */
@Repository
public interface CoefModuleConcoursDao extends JpaRepository<CoefModuleConcours, Long> {
    
        public CoefModuleConcours findByCoef(Double coef);

}
