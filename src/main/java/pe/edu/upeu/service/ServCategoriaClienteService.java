package pe.edu.upeu.service;

import java.util.List;
import java.util.Optional;
import pe.edu.upeu.model.ServCategoriaCliente;

/**
 *
 * @author davidmp
 */
public interface ServCategoriaClienteService {
    ServCategoriaCliente save(ServCategoriaCliente categoria);
    List<ServCategoriaCliente> findAll();
    void delete(int id);  
    
    public Optional<ServCategoriaCliente> getOne(int id);    
    public boolean existsById(int id);
    public Optional<ServCategoriaCliente> getByNombreC(String nombreC);
    public boolean existsByNombreC(String nombreC);     
}