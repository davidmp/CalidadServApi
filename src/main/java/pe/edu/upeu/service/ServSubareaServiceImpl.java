/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.dao.ServSubareaDao;
import pe.edu.upeu.model.ServSubarea;

/**
 *
 * @author LabSoftware
 */
@Service
public class ServSubareaServiceImpl implements ServSubareaService{

    @Autowired
    private ServSubareaDao dao;      
    
    @Override
    public ServSubarea save(ServSubarea subarea) {
        return dao.save(subarea);
    }

    @Override
    public List<ServSubarea> findAll() {
        List<ServSubarea> list = new ArrayList<>();
        dao.findAll().iterator().forEachRemaining(list::add);
        return list;        
    }

    @Override
    public void delete(int id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<ServSubarea> getOne(int id) {
         return dao.findById(id);
    }



    @Override
    public boolean existsById(int id) {
         return dao.existsById(id);
    }
    
    @Override
    public Optional<ServSubarea> getByNombreSa(String nombreSa) {
        return dao.findByNombreSa(nombreSa);
    }
    
    @Override
    public boolean existsByNombreSa(String nombreSa) {
        return dao.existsByNombreSa(nombreSa);
    }
    
}
