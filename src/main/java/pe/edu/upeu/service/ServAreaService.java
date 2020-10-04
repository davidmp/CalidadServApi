/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import java.util.Optional;
import pe.edu.upeu.model.ServArea;

/**
 *
 * @author LabSoftware
 */
public interface ServAreaService {
    ServArea save(ServArea area);
    List<ServArea> findAll();
    void delete(int id);   
    
    public Optional<ServArea> getOne(int id);    
    public boolean existsById(int id);
    public Optional<ServArea> getByNombreA(String nombreA);
    public boolean existsByNombreA(String nombreA);    
}
