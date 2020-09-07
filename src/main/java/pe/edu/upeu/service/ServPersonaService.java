/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import pe.edu.upeu.model.ServPersona;

/**
 *
 * @author davidmp
 */
public interface ServPersonaService {
     ServPersona save(ServPersona user);

    List<ServPersona> findAll();

    void delete(int id);   
    ServPersona login(String user, String passw);
}
