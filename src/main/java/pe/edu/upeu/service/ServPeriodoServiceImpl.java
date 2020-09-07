package pe.edu.upeu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.dao.ServPeriodoDao;

import pe.edu.upeu.model.ServPeriodo;

/**
 *
 * @author davidmp
 */
@Service //UserDetailsService
public class ServPeriodoServiceImpl implements ServPeriodoService {
    
    @Autowired
    private ServPeriodoDao dao;

    @Override
    public ServPeriodo save(ServPeriodo user) {
        return dao.save(user);
    }

    @Override
    public List<ServPeriodo> findAll() {
        List<ServPeriodo> list = new ArrayList<>();
        dao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(int id) {
        dao.deleteById(id);
    }
    
    @Override
    public Optional<ServPeriodo> getOne(int id){
        return dao.findById(id);
    }

    @Override
    public Optional<ServPeriodo> getByPeriodo(String periodo){
        return dao.findByPeriodo(periodo);
    }

    @Override
    public boolean existsById(int id){
        return dao.existsById(id);
    }

    @Override
    public boolean existsByPeriodo(String periodo){
        return dao.existsByPeriodo(periodo);
    }    
    
}