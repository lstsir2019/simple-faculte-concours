/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.bean.dao;

import com.faculte.concoursapi.bean.Concours;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BOSS
 */
@Repository
public interface ConcoursDao extends JpaRepository<Concours, Long> {

    public Concours findByReference(String reference);

    public Concours findByRefFiliere(String refFiliere);

    public List<Concours> findByAnneeConcours(int anneeConcours);
}
