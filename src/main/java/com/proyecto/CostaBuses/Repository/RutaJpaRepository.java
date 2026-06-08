package com.proyecto.CostaBuses.Repository;

import com.proyecto.CostaBuses.Model.Ruta;
import com.proyecto.CostaBuses.Model.dto.RutaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RutaJpaRepository extends JpaRepository<Ruta,Integer>
{
    List<Ruta> findAll();

    Ruta getByCodigo(String codigo);

    Ruta save(RutaDto rutaDto);

    boolean existsByCodigo(String codigo);

    Optional<Ruta> findByCodigo(String codigo);

    Ruta deleteByCodigo(String codigo);
}
