package pe.edu.upeu.service;

import java.util.List;
import pe.edu.upeu.model.ServCategoriaCliente;

/**
 *
 * @author davidmp
 */
public interface ServCategoriaClienteService {
    ServCategoriaCliente save(ServCategoriaCliente user);

    List<ServCategoriaCliente> findAll();

    void delete(int id);
}