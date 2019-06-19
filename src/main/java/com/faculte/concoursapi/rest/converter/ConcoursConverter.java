/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.converter;

import com.faculte.concoursapi.bean.Concours;
import com.faculte.concoursapi.bean.ModuleConcours;
import com.faculte.concoursapi.common.util.NumberUtil;
import com.faculte.concoursapi.commun.util.DateUtil;
import com.faculte.concoursapi.rest.vo.ConcoursVo;
import com.faculte.concoursapi.rest.vo.ModuleConcoursVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



/**
 *
 * @author BOSS
 */
@Component
public class ConcoursConverter extends AbstractConverter<Concours, ConcoursVo> {

//    @Autowired
//    @Qualifier("moduleConcoursConverter")
//    private AbstractConverter<ModuleConcours,ModuleConcoursVo> moduleConcoursConverter;
//    
    @Override
    public Concours toItem(ConcoursVo vo) {
        if (vo == null) {
            return null;
        } else {
            Concours item = new Concours();
            item.setId(vo.getId());
            item.setReference(vo.getReference());
            item.setAnneeConcours(NumberUtil.toInt(vo.getAnneeConcours()));
            item.setDateConcoursEcrit(DateUtil.parse(vo.getDateConcoursEcrit()));
            item.setDateConcoursOral(DateUtil.parse(vo.getDateConcoursOral()));
            item.setRefFiliere(vo.getRefFiliere());
            item.setNbreplace(NumberUtil.toInt(vo.getNbreplace()));
            item.setModuleConcourss(new ModuleConcoursConverter().toItem(vo.getModuleConcoursVo()));
            item.setNbreplaceConcoursEcrit(NumberUtil.toInt(vo.getNbreplaceConcoursEcrit()));
            item.setNbreplaceConcoursOral(NumberUtil.toInt(vo.getNbreplaceConcoursOral()));

            return item;
        }
    }

    @Override
    public ConcoursVo toVo(Concours item) {
        if (item == null) {
            return null;
        } else {
            ConcoursVo vo = new ConcoursVo();
            vo.setId(item.getId());
            vo.setReference(item.getReference());
            vo.setAnneeConcours(NumberUtil.toString(item.getAnneeConcours()));
            vo.setDateConcoursEcrit(DateUtil.formateDate(item.getDateConcoursEcrit()));
            vo.setDateConcoursOral(DateUtil.formateDate(item.getDateConcoursOral()));
            vo.setRefFiliere(item.getRefFiliere());
            vo.setNbreplace(NumberUtil.toString(item.getNbreplace()));
            vo.setModuleConcoursVo(new ModuleConcoursConverter().toVo(item.getModuleConcourss()));
            vo.setNbreplaceConcoursEcrit(NumberUtil.toString(item.getNbreplaceConcoursEcrit()));
            vo.setNbreplaceConcoursOral(NumberUtil.toString(item.getNbreplaceConcoursOral()));
            return vo;
        }

    }
}
