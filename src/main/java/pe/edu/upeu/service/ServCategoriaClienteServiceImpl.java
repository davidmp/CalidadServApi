package pe.edu.upeu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.dao.ServCategoriaClienteDao;
import pe.edu.upeu.model.ServCategoriaCliente;

/**
 *
 * @author davidmp
 */
@Service
public class ServCategoriaClienteServiceImpl implements ServCategoriaClienteService {

    @Autowired
    private ServCategoriaClienteDao dao;


    @Override
    public ServCategoriaCliente save(ServCategoriaCliente user) {
        return dao.save(user);
    }

    @Override
    public List<ServCategoriaCliente> findAll() {
        List<ServCategoriaCliente> list = new ArrayList<>();
        dao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(int id) {
        dao.deleteById(id);
    }


    @Override
    public Optional<ServCategoriaCliente> getOne(int id) {
        return dao.findById(id);
    }



    @Override
    public boolean existsById(int id) {
         return dao.existsById(id);
    }

    @Override
    public Optional<ServCategoriaCliente> getByNombreC(String nombreC) {
       return dao.findByNombreC(nombreC);
    }    
    @Override
    public boolean existsByNombreC(String nombreC) {
        return dao.existsByNombreC(nombreC);
    }    
    
}
