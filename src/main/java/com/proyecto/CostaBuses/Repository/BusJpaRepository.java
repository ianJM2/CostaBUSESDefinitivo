package com.proyecto.CostaBuses.Repository;

import com.proyecto.CostaBuses.Model.Bus;
import com.proyecto.CostaBuses.Model.dto.BusDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusJpaRepository extends JpaRepository<Bus, Integer>
{
    List<Bus> findAll();

    Bus save(BusDto busDto);

    Bus getByPlaca(String placa);

    Bus getByConductor (String conductor);

    boolean existsById(Integer id );

    boolean existsByPlaca (String Placa);

    Optional<Bus> findById(Integer id);

    Optional<Bus> findByPlaca(String placa);

    Bus deleteByPlaca(String Placa);




}
