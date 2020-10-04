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
import pe.edu.upeu.dao.ServAreaDao;
import pe.edu.upeu.model.ServArea;

/**
 *
 * @author LabSoftware
 */
@Service
public class ServAreaServiceImpl implements ServAreaService{

    @Autowired
    private ServAreaDao dao;    
    
    @Override
    public ServArea save(ServArea area) {
        return dao.save(area);
    }

    @Override
    public List<ServArea> findAll() {
        List<ServArea> list = new ArrayList<>();
        dao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(int id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<ServArea> getOne(int id) {
        return dao.findById(id);
    }



    @Override
    public boolean existsById(int id) {
         return dao.existsById(id);
    }

    @Override
    public Optional<ServArea> getByNombreA(String nombreA) {
       return dao.findByNombreA(nombreA);
    }    
    @Override
    public boolean existsByNombreA(String nombreA) {
        return dao.existsByNombreA(nombreA);
    }
    
}
