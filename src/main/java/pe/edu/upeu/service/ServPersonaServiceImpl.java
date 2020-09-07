/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.dao.ServPersonaDao;

import pe.edu.upeu.model.ServPersona;

/**
 *
 * @author davidmp
 */
@Service
public class ServPersonaServiceImpl implements ServPersonaService {
    
    @Autowired
    private ServPersonaDao dao;
   
    
    @Override
    public ServPersona save(ServPersona user) {
        return dao.save(user);
    }

    @Override
    public List<ServPersona> findAll() {
        List<ServPersona> list = new ArrayList<>();
        dao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(int id) {
        dao.deleteById(id);
    }

    @Override
    public ServPersona login(String user, String passw){
        return dao.login(user, passw);
    }
    
}
