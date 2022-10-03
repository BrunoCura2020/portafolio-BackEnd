package com.portafolio.demo.Repository;

import com.portafolio.demo.Entity.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcercaDe extends JpaRepository<AcercaDe, Integer>{
    public Optional<AcercaDe> findByDescripcion(String descripcion);
    public boolean existsByDescripcion(String descripcion);
}
