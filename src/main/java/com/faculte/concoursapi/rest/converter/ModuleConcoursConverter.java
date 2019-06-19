/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.converter;

import com.faculte.concoursapi.bean.CoefModuleConcours;
import com.faculte.concoursapi.bean.ModuleConcours;
import com.faculte.concoursapi.rest.vo.CoefModuleConcoursVo;
import com.faculte.concoursapi.rest.vo.ModuleConcoursVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author BOSS
 */
@Component
//@Qualifier("coefModuleConcoursConverter")
public class ModuleConcoursConverter extends AbstractConverter<ModuleConcours, ModuleConcoursVo> {

//    private AbstractConverter<CoefModuleConcours, CoefModuleConcoursVo> coefModuleConcoursConverter;
    @Override
    public ModuleConcours toItem(ModuleConcoursVo vo) {
        if (vo == null) {
            return null;
        } else {
            ModuleConcours item = new ModuleConcours();
            item.setReference(vo.getReference());
            item.setId(vo.getId());
//            item.setConcours(new ConcoursConverter().toItem(vo.getConcoursVo()));
            item.setCoefModuleConcours(new CoefModuleConcoursConverter().toItem(vo.getCoefModuleConcoursVo()));

            return item;
        }

    }

    @Override
    public ModuleConcoursVo toVo(ModuleConcours item) {
        if (item == null) {
            return null;
        } else {
            ModuleConcoursVo vo = new ModuleConcoursVo();
            vo.setReference(item.getReference());
            vo.setId(item.getId());
//            vo.setConcoursVo(new ConcoursConverter().toVo(item.getConcours()));
            vo.setCoefModuleConcoursVo(new CoefModuleConcoursConverter().toVo(item.getCoefModuleConcours()));
            return vo;
        }

    }

}
