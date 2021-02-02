package com.BootJpa.dao;

import com.BootJpa.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlienRepo extends CrudRepository<Alien,Integer> {
    Alien getOne(int aid);


   /* List<Alien> findByTech(String tech);
    List<Alien> findByAidGreaterThan(int aid);
    @Query("from Alien where tech=?1 order by aname")
    List<Alien> findByTechSorted(String tech);*/

}
