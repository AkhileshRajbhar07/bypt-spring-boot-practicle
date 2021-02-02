package com.BootJpa.controller;

import com.BootJpa.dao.AlienRepo;
import com.BootJpa.model.Alien;
import com.sun.xml.bind.v2.model.core.ID;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.AllPermission;
import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {
    @Autowired
    AlienRepo repo;
    @RequestMapping("/")
    public String home()
    {
        System.out.println("hi");
        return "home.jsp";
    }
    @PostMapping(path="alien"/*, consumes = {"application/json"}*/)
    public  Alien  addAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }
    @DeleteMapping("alien/{aid}")
    public String deleteAlien(@PathVariable int aid){
        Alien a= repo.getOne(aid);
        repo.delete(a);
         return "deleted";
    }
    @PutMapping("alien")
    public Alien updateAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }
   /* @RequestMapping("addAlien")
    public String addAlien(Alien alien){
        //repo.save(alien);
        return "home.jsp";
    }*/
    /*@RequestMapping("getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv= new ModelAndView("ShowAlien.jsp");
         Alien alien = repo.findById(aid).orElse(new Alien());
        *//*System.out.println(repo.findByTech("java"));
        System.out.println(repo.findByAidGreaterThan(102));
        System.out.println(repo.findByTechSorted("java"));*//*
        mv.addObject(alien);
        return mv;
    }*/
   /* @RequestMapping("aliens")
    @ResponseBody
    public String getAliens(){

        return repo.findAll().toString();
    }*/
    @RequestMapping(path="aliens" /*, produces = {"application/xml"}*/)

    public List<Alien> getAliens(){

        return (List<Alien>) repo.findAll();
    }
    /*@RequestMapping("/alien/{aid}")
    @ResponseBody
    public String alien(@PathVariable("aid") int aid){
        return repo.findById(aid).toString();
    }*/
    @RequestMapping(value = "/alien/{aid}")

    public Optional<Alien> getAlien(@PathVariable("aid") int aid){

        return repo.findById(aid);
    }
}
