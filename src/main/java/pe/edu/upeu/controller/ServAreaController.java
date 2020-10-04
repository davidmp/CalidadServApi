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
import pe.edu.upeu.model.ServArea;
import pe.edu.upeu.service.ServAreaService;

/**
 *
 * @author LabSoftware
 */
@RestController
@RequestMapping("/area")
@CrossOrigin(origins = "*")
public class ServAreaController {

    @Autowired
    private ServAreaService areaService;  
    
    @GetMapping("/lista")
    public ResponseEntity<List<ServArea>> list(){
        List<ServArea> list = areaService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ServArea> getById(@PathVariable("id") int id){
        if(!areaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ServArea producto = areaService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<ServArea> getByNombre(@PathVariable("nombre") String nombre){
        if(!areaService.existsByNombreA(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ServArea producto = areaService.getByNombreA(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServArea area){
        if(StringUtils.isBlank(area.getNombreA()))
            return new ResponseEntity(new Mensaje("el area es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(areaService.existsByNombreA(area.getNombreA()))
            return new ResponseEntity(new Mensaje("ese area ya existe"), HttpStatus.BAD_REQUEST);
        areaService.save(area);
        return new ResponseEntity(new Mensaje("Area creado"), HttpStatus.OK);
    }    
   
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ServArea area){
        if(!areaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(areaService.existsByNombreA(area.getNombreA()) && areaService.getByNombreA(area.getNombreA()).get().getIdArea()!= id)
            return new ResponseEntity(new Mensaje("ese area ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(area.getNombreA()))
            return new ResponseEntity(new Mensaje("el nombre de area es obligatorio"), HttpStatus.BAD_REQUEST);
        area.setIdArea(areaService.getOne(id).get().getIdArea());
        areaService.save(area);
        return new ResponseEntity(new Mensaje("Area actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!areaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        areaService.delete(id);
        return new ResponseEntity(new Mensaje("Area eliminada"), HttpStatus.OK);
    }       
}
