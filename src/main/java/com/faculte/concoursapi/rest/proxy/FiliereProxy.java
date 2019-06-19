/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest.proxy;

import com.faculte.concoursapi.rest.vo.exchange.FiliereVo;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author BOSS
 */
@FeignClient(name = "zuul-server")

public interface FiliereProxy {

//    @GetMapping("efaculte-v1-api/fillieres/references/{reference}")
//    public FiliereVo findByReference(@PathVariable("reference") String reference);
    @GetMapping("/microservice1-etudiant/efaculte-v1-api/fillieres/abreviation/{abreviation}")
    public FiliereVo findByAbreviation(@PathVariable("abreviation") String abreviation);

    @GetMapping("/microservice1-etudiant/efaculte-v1-api/fillieres/type/{type}")
    public List<FiliereVo> findByTypeFiliere(@PathVariable("type") int type);
}
