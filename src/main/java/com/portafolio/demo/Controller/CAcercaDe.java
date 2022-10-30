/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.demo.Controller;

import com.portafolio.demo.Dto.dtoAcercaDe;
import com.portafolio.demo.Entity.AcercaDe;
import com.portafolio.demo.Security.Controller.Mensaje;
import com.portafolio.demo.Service.SAcercaDe;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercaDe")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://front-portafolio.web.app")
public class CAcercaDe {
    @Autowired 
    SAcercaDe sAcercaDe;
    
    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDe>> list(){
        List<AcercaDe> list = sAcercaDe.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAcercaDe.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    sAcercaDe.delete(id);
    return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercaDe dtoacercaDe){
       if(StringUtils.isBlank(dtoacercaDe.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        
        if(sAcercaDe.existsByDescripcion(dtoacercaDe.getDescripcion()))
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        AcercaDe acercaDe = new AcercaDe(dtoacercaDe.getDescripcion());
        sAcercaDe.save(acercaDe);
        
        return new ResponseEntity(new Mensaje("Acerca de agregado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe>getById(@PathVariable("id") int id){
        if(!sAcercaDe.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        AcercaDe acercaDe = sAcercaDe.getOne(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercaDe dtoacercade){
        //Validamos si existe el ID
        if(!sAcercaDe.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sAcercaDe.existsByDescripcion(dtoacercade.getDescripcion()) && sAcercaDe.getByDescripcion(dtoacercade.getDescripcion()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa información ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoacercade.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatorio"), HttpStatus.BAD_REQUEST);
        
        AcercaDe acercade = sAcercaDe.getOne(id).get();
        acercade.setDescripcion(dtoacercade.getDescripcion());
   
        sAcercaDe.save(acercade);
        return new ResponseEntity(new Mensaje("Información actualizada"), HttpStatus.OK);
    }
    
}
