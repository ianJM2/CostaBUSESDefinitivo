package com.proyecto.CostaBuses.Repository;

import com.proyecto.CostaBuses.Model.Parada;
import com.proyecto.CostaBuses.Model.dto.ParadaDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParadaJpaRepository extends JpaRepository<Parada, Integer>
{

    List<Parada> findAll();

    Optional<Parada> findById(String id);

    Parada getById(String id);

    Parada save(ParadaDto paradaDto);

    boolean existsById(String id);

    Parada deleteById(String id);

}