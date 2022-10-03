/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.demo.Service;

import com.portafolio.demo.Entity.AcercaDe;
import com.portafolio.demo.Repository.RAcercaDe;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcercaDe {
    @Autowired
    RAcercaDe rAcercaDe;
    
    public List<AcercaDe> list(){
        return rAcercaDe.findAll();
    }
    
    public Optional<AcercaDe> getOne(int id){
        return rAcercaDe.findById(id);
    }
   
    public Optional<AcercaDe> getByDescripcion(String descripcion){
        return rAcercaDe.findByDescripcion(descripcion);
    }
    
    public void save(AcercaDe descripcion){
        rAcercaDe.save(descripcion);
    }
    
    public void delete(int id){
        rAcercaDe.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAcercaDe.existsById(id);
    }
    
    public boolean existsByDescripcion(String descripcion){
        return rAcercaDe.existsByDescripcion(descripcion);
    }
}
