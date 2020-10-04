/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.controller;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.dto.Mensaje;
import pe.edu.upeu.model.ServSubarea;
import pe.edu.upeu.service.ServSubareaService;

/**
 *
 * @author LabSoftware
 */
@RestController
@RequestMapping("/subarea")
@CrossOrigin(origins = "*")
public class ServSubareaController {

    @Autowired
    private ServSubareaService areaService;  
    
    @GetMapping("/lista")
    public ResponseEntity<List<ServSubarea>> list(){
        List<ServSubarea> list = areaService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ServSubarea> getById(@PathVariable("id") int id){
        if(!areaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ServSubarea producto = areaService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<ServSubarea> getByNombre(@PathVariable("nombre") String nombre){
        if(!areaService.existsByNombreSa(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ServSubarea producto = areaService.getByNombreSa(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServSubarea subarea){
        if(StringUtils.isBlank(subarea.getNombreSa()))
            return new ResponseEntity(new Mensaje("el subarea es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(areaService.existsByNombreSa(subarea.getNombreSa()))
            return new ResponseEntity(new Mensaje("ese subarea ya existe"), HttpStatus.BAD_REQUEST);
        areaService.save(subarea);
        return new ResponseEntity(new Mensaje("Subarea creado"), HttpStatus.OK);
    }    
   
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ServSubarea subarea){
        if(!areaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(areaService.existsByNombreSa(subarea.getNombreSa()) && areaService.getByNombreSa(subarea.getNombreSa()).get().getIdSubarea()!= id)
            return new ResponseEntity(new Mensaje("ese subarea ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(subarea.getNombreSa()))
            return new ResponseEntity(new Mensaje("el nombre de subarea es obligatorio"), HttpStatus.BAD_REQUEST);
        subarea.setIdArea(areaService.getOne(id).get().getIdArea());
        areaService.save(subarea);
        return new ResponseEntity(new Mensaje("Subarea actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!areaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        areaService.delete(id);
        return new ResponseEntity(new Mensaje("Subarea eliminada"), HttpStatus.OK);
    }      
}
