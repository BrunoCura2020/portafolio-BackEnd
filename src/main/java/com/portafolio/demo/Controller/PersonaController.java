package com.portafolio.demo.Controller;

import com.portafolio.demo.Entity.Persona;
import com.portafolio.demo.Interface.IPersonaService;
import com.portafolio.demo.Security.Controller.Mensaje;
import com.portafolio.demo.Service.SPersona;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://front-portafolio.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    SPersona sPersona;

    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }

    @PostMapping("/persona/crear")
    public String crearPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada exitosamente";
    }
    
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada exitosamente";
    }
    
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id, 
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevaImg){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
        
        ipersonaService.savePersona(persona);
        return persona;
        
    }
    
@GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }

 @GetMapping("/persona/detail/{id}")
    public ResponseEntity<Persona>getById(@PathVariable("id") Long id){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
