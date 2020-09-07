package pe.edu.upeu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.model.ServCategoriaCliente;

@Repository
public interface ServCategoriaClienteDao extends JpaRepository<ServCategoriaCliente, Integer> {

}