/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.controller;

import java.util.List;
import pe.edu.upeu.dto.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.model.ServPeriodo;
import pe.edu.upeu.service.ServPeriodoService;

/**
 *
 * @author davidmp
 */
@RestController
@RequestMapping("/periodo")
@CrossOrigin(origins = "*")
public class ServPeriodoController {

    @Autowired
    private ServPeriodoService periodoService;  
    
    @GetMapping("/lista")
    public ResponseEntity<List<ServPeriodo>> list(){
        List<ServPeriodo> list = periodoService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ServPeriodo> getById(@PathVariable("id") int id){
        if(!periodoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ServPeriodo producto = periodoService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<ServPeriodo> getByNombre(@PathVariable("nombre") String nombre){
        if(!periodoService.existsByPeriodo(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ServPeriodo producto = periodoService.getByPeriodo(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServPeriodo productoDto){
        if(StringUtils.isBlank(productoDto.getPeriodo()))
            return new ResponseEntity(new Mensaje("el periodo es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(periodoService.existsByPeriodo(productoDto.getPeriodo()))
            return new ResponseEntity(new Mensaje("ese periodo ya existe"), HttpStatus.BAD_REQUEST);
        periodoService.save(productoDto);
        return new ResponseEntity(new Mensaje("Periodo creado"), HttpStatus.OK);
    }    
   
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ServPeriodo periodo){
        if(!periodoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(periodoService.existsByPeriodo(periodo.getPeriodo()) && periodoService.getByPeriodo(periodo.getPeriodo()).get().getIdPeriodo()!= id)
            return new ResponseEntity(new Mensaje("ese periodo ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(periodo.getPeriodo()))
            return new ResponseEntity(new Mensaje("el nombre de periodo es obligatorio"), HttpStatus.BAD_REQUEST);
        periodo.setIdPeriodo(periodoService.getOne(id).get().getIdPeriodo());
        periodoService.save(periodo);
        return new ResponseEntity(new Mensaje("Periodo actualizado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!periodoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        periodoService.delete(id);
        return new ResponseEntity(new Mensaje("Periodo eliminado"), HttpStatus.OK);
    }    
    
}
