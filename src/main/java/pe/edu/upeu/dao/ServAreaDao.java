/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.model.ServArea;

/**
 *
 * @author LabSoftware
 */
@Repository
public interface ServAreaDao extends JpaRepository<ServArea, Integer>{
    Optional<ServArea> findByNombreA(String nombreA);
    boolean existsByNombreA(String nombreA);     
}
