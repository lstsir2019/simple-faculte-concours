/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.concoursapi.rest;

import com.faculte.concoursapi.bean.CoefModuleConcours;
import com.faculte.concoursapi.bean.Concours;
import com.faculte.concoursapi.bean.ModuleConcours;
import com.faculte.concoursapi.rest.converter.CoefModuleConcoursConverter;
import com.faculte.concoursapi.rest.converter.ConcoursConverter;
import com.faculte.concoursapi.rest.converter.ModuleConcoursConverter;
import com.faculte.concoursapi.rest.vo.CoefModuleConcoursVo;
import com.faculte.concoursapi.rest.vo.ConcoursVo;
import com.faculte.concoursapi.rest.vo.ModuleConcoursVo;
import com.faculte.concoursapi.rest.vo.exchange.FiliereVo;
import com.faculte.concoursapi.service.CoefModuleConcoursService;
import com.faculte.concoursapi.service.ConcoursService;
import com.faculte.concoursapi.service.ModuleConcoursService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BOSS
 */
@RestController()
@RequestMapping("/concours-api/concours")
@CrossOrigin(origins = "http://localhost:4200")//exposedHeaders = "Access-Control-Allow-Origin"
public class ConcoursRest {

    @Autowired
    private ConcoursService concoursService;

    @Autowired
    private ModuleConcoursService moduleConcoursService;
    @Autowired
    private CoefModuleConcoursService coefModuleConcoursService;

    @PutMapping("/module-concours/update/")
    public int updateModuleConcours(@RequestBody ModuleConcoursVo moduleConcoursVo) {
        ModuleConcours myModule = new ModuleConcoursConverter().toItem(moduleConcoursVo);
        return moduleConcoursService.updateModuleConcours(myModule);
    }

    @GetMapping("/reference/{refConcours}/module-concours/reference/{refModule}")
    public ModuleConcoursVo findByReferenceAndConcoursReference(@PathVariable("refModule") String refModule, @PathVariable("refConcours") String refConcours) {
        return new ModuleConcoursConverter().toVo(moduleConcoursService.findByReferenceAndConcoursReference(refModule, refConcours));
    }

    @GetMapping("/module-concours/{id}")
    public ModuleConcoursVo findById(@PathVariable Long id) {
        return new ModuleConcoursConverter().toVo(moduleConcoursService.findById(id));
    }

//    @Qualifier("concoursConverter")
//    private AbstractConverter<Concours, ConcoursVo> concoursConverter;
    ConcoursConverter concoursConverter = new ConcoursConverter();

    @PostMapping("/")
    public int saveConcoursComplet(@RequestBody ConcoursVo concoursVo) {

        Concours myConcours = concoursConverter.toItem(concoursVo);
        return concoursService.saveConcoursComplet(myConcours);
    }

    @GetMapping("/reference/{reference}/module-concours")
    public List<ModuleConcoursVo> findByConcoursReference(@PathVariable("reference") String reference) {
        List<ModuleConcours> moduleConcourses = moduleConcoursService.findByConcoursReference(reference);
        ModuleConcoursConverter moduleConcoursConverter = new ModuleConcoursConverter();
        return moduleConcoursConverter.toVo(moduleConcourses);
    }

    @GetMapping("/filiere/type/{type}")
    public List<FiliereVo> findfiliereByTypeFiliere(@PathVariable int type) {
        return concoursService.findfiliereByTypeFiliere(type);
    }

    @GetMapping("/coef-module-concours/{id}")
    public CoefModuleConcoursVo findCoefById(@PathVariable Long id) {
        return new CoefModuleConcoursConverter().toVo(coefModuleConcoursService.findCoefById(id));
    }

    @PutMapping("/coef-module-concours/update/{id}")
    public int updateCoef(@RequestBody CoefModuleConcoursVo cmcVo) {
        CoefModuleConcours coefModuleConcours = new CoefModuleConcoursConverter().toItem(cmcVo);
        return coefModuleConcoursService.updateCoef(coefModuleConcours);
    }

//    
//      @GetMapping("/reference/{reference}")
//    public ModuleConcoursVo findByModuleReference(@PathVariable String reference) {
//        return new ModuleConcoursConverter().toVo(moduleConcoursService.findByReference(reference));
//    }
    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    public List<ConcoursVo> findAll() {
        return concoursConverter.toVo(concoursService.findAll());
    }

    @DeleteMapping("/reference/{reference}")
    public int DeleteConcours(Concours concours) {
        return concoursService.DeleteConcours(concours);
    }

    @PutMapping("/reference/{reference}/")
    public int AddModuletoConcours(@PathVariable String reference, @RequestBody ModuleConcours moduleConcours) {
        return concoursService.AddModuletoConcours(reference, moduleConcours);
    }

    @DeleteMapping("/module-concours/reference/{id}")
    public int DeleteModuleConcoursById(@PathVariable("id") Long id) {
        return moduleConcoursService.DeleteModuleConcoursById(id);
    }

    @GetMapping("/reference/{reference}")
    public ConcoursVo findByReference(@PathVariable String reference) {
        return concoursConverter.toVo(concoursService.findByReference(reference));
    }

    @PostMapping("/search")
    public List<ConcoursVo> findByCreteria(@RequestBody ConcoursVo concoursVo) {
        return concoursConverter.toVo(concoursService.findByCreteria(concoursVo.getReference(), concoursVo.getRefFiliere(), concoursVo.getAnneeConcours()));
    }

    @PutMapping("/update/")
    public int updateConcours(@RequestBody ConcoursVo concoursVo) {
        Concours myConcours = concoursConverter.toItem(concoursVo);
        return concoursService.updateConcours(myConcours);
    }

    @GetMapping("/total_coef/{refConcours}")
    public double totalCoef(@PathVariable String refConcours) {
        return coefModuleConcoursService.totalCoef(refConcours);
    }

    @GetMapping("/annee/{anneeConcours}")
    public List<ConcoursVo> findByAnneeConcours(@PathVariable("anneeConcours") int anneeConcours) {
        return concoursConverter.toVo(concoursService.findByAnneeConcours(anneeConcours));
    }

    public ConcoursService getConcoursService() {
        return concoursService;
    }

    public void setConcoursService(ConcoursService concoursService) {
        this.concoursService = concoursService;
    }

    public ModuleConcoursService getModuleConcoursService() {
        return moduleConcoursService;
    }

    public void setModuleConcoursService(ModuleConcoursService moduleConcoursService) {
        this.moduleConcoursService = moduleConcoursService;
    }

    public ConcoursConverter getConcoursConverter() {
        return concoursConverter;
    }

    public void setConcoursConverter(ConcoursConverter concoursConverter) {
        this.concoursConverter = concoursConverter;
    }

}
