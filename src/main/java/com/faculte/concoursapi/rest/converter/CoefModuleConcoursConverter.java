/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.converter;

import com.faculte.concoursapi.bean.CoefModuleConcours;
import com.faculte.concoursapi.common.util.NumberUtil;
import com.faculte.concoursapi.rest.vo.CoefModuleConcoursVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author BOSS
 */
@Component
public class CoefModuleConcoursConverter extends AbstractConverter<CoefModuleConcours, CoefModuleConcoursVo> {

    @Override
    public CoefModuleConcours toItem(CoefModuleConcoursVo vo) {
        if (vo == null) {
            return null;
        } else {
            CoefModuleConcours item = new CoefModuleConcours();
            item.setId(vo.getId());
            item.setCoef(NumberUtil.toDouble(vo.getCoef()));
            item.setRefFiliere(vo.getRefFiliere());
            return item;
        }

    }

    @Override
    public CoefModuleConcoursVo toVo(CoefModuleConcours item) {
        if (item == null) {
            return null;
        } else {
            CoefModuleConcoursVo vo = new CoefModuleConcoursVo();
            vo.setId(item.getId());
            vo.setCoef(NumberUtil.toString(item.getCoef()));
            vo.setRefFiliere(item.getRefFiliere());
            return vo;
        }
    }

}
