package pe.edu.upeu.dao;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.model.ServPeriodo;


@Repository
public interface ServPeriodoDao extends JpaRepository<ServPeriodo, Integer> {
    Optional<ServPeriodo> findByPeriodo(String periodo);
    boolean existsByPeriodo(String periodo);    
}