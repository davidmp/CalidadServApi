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
import pe.edu.upeu.model.ServCategoriaCliente;
import pe.edu.upeu.service.ServCategoriaClienteService;

/**
 *
 * @author LabSoftware
 */
@RestController
@RequestMapping("/categorClient")
@CrossOrigin(origins = "*")
public class ServCategoriaClienteController {
    @Autowired
    private ServCategoriaClienteService categoriaClienteService;  
    
    @GetMapping("/lista")
    public ResponseEntity<List<ServCategoriaCliente>> list(){
        List<ServCategoriaCliente> list = categoriaClienteService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")    
    @GetMapping("/lista2")
    public ResponseEntity<List<ServCategoriaCliente>> list2(){
        List<ServCategoriaCliente> list = categoriaClienteService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }    

    @GetMapping("/detail/{id}")
    public ResponseEntity<ServCategoriaCliente> getById(@PathVariable("id") int id){
        if(!categoriaClienteService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ServCategoriaCliente producto = categoriaClienteService.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<ServCategoriaCliente> getByNombre(@PathVariable("nombre") String nombre){
        if(!categoriaClienteService.existsByNombreC(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ServCategoriaCliente producto = categoriaClienteService.getByNombreC(nombre).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServCategoriaCliente area){
        if(StringUtils.isBlank(area.getNombreC()))
            return new ResponseEntity(new Mensaje("el nombre de categoria es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(categoriaClienteService.existsByNombreC(area.getNombreC()))
            return new ResponseEntity(new Mensaje("ese nombre de categoria ya existe"), HttpStatus.BAD_REQUEST);
        categoriaClienteService.save(area);
        return new ResponseEntity(new Mensaje("Categoria Cliente creado"), HttpStatus.OK);
    }    
   
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ServCategoriaCliente area){
        if(!categoriaClienteService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(categoriaClienteService.existsByNombreC(area.getNombreC()) && categoriaClienteService.getByNombreC(area.getNombreC()).get().getIdCategoriaCliente()!= id)
            return new ResponseEntity(new Mensaje("ese nombre de categoria ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(area.getNombreC()))
            return new ResponseEntity(new Mensaje("el nombre de categoria es obligatorio"), HttpStatus.BAD_REQUEST);
        area.setIdCategoriaCliente(categoriaClienteService.getOne(id).get().getIdCategoriaCliente());
        categoriaClienteService.save(area);
        return new ResponseEntity(new Mensaje("Categoria cliente actualizada"), HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!categoriaClienteService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        categoriaClienteService.delete(id);
        return new ResponseEntity(new Mensaje("Categoria cliente eliminada"), HttpStatus.OK);
    }      
}
