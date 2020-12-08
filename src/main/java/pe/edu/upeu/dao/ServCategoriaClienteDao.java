package pe.edu.upeu.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.model.ServCategoriaCliente;

@Repository
public interface ServCategoriaClienteDao extends JpaRepository<ServCategoriaCliente, Integer> {
    Optional<ServCategoriaCliente> findByNombreC(String nombreC);
    boolean existsByNombreC(String nombreC); 
}