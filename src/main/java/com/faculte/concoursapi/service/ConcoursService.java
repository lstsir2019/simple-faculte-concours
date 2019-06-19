/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.service;

import com.faculte.concoursapi.bean.Concours;
import com.faculte.concoursapi.bean.ModuleConcours;
import com.faculte.concoursapi.rest.vo.exchange.FiliereVo;
import java.util.List;

/**
 *
 * @author BOSS
 */
public interface ConcoursService {

    public int saveConcoursComplet(Concours concours);

    public int DeleteConcours(Concours concours);

    public Concours findByReference(String reference);

    public Concours findByRefFiliere(String refFiliere);

    public List<Concours> findByAnneeConcours(int anneeConcours);

    public List<FiliereVo> findfiliereByTypeFiliere(int type);

    public int AddModuletoConcours(String reference, ModuleConcours moduleConcours);

    public List<Concours> findAll();

    public List<Concours> findByCreteria(String reference, String refFiliere, String anneeConcours);

    public int updateConcours(Concours concours);
}
