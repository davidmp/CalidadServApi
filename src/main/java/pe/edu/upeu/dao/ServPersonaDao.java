/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.model.ServPersona;

/**
 *
 * @author davidmp
 */
@Repository
public interface ServPersonaDao extends JpaRepository<ServPersona, Integer>{
    //ServPersona findByUsername(String nombre);
    @Query("select p from ServPersona p  where p.usuario=?1 and p.clave=?2")
    ServPersona login(String user, String passw);
}
