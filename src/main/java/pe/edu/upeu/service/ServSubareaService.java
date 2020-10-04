/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import java.util.Optional;
import pe.edu.upeu.model.ServSubarea;

/**
 *
 * @author LabSoftware
 */
public interface ServSubareaService {
    ServSubarea save(ServSubarea subarea);
    List<ServSubarea> findAll();
    void delete(int id);   
    
    public Optional<ServSubarea> getOne(int id);
    
    public boolean existsById(int id);
    public Optional<ServSubarea> getByNombreSa(String nombreSa);
    public boolean existsByNombreSa(String nombreSa);      
}
