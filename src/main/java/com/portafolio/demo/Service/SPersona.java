/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.demo.Service;

import com.portafolio.demo.Entity.Persona;
import com.portafolio.demo.Repository.RPersona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class SPersona {
    @Autowired
    RPersona rPersona;
    
    public List<Persona> list(){
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(Long id){
        return rPersona.findById(id);
    }
   
    public Optional<Persona> getByNombre(String nombre){
        return rPersona.findByNombre(nombre);
    }
    
    public void save(Persona expe){
        rPersona.save(expe);
    }
    
    public void delete(Long id){
        rPersona.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return rPersona.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rPersona.existsByNombre(nombre);
    }
}
