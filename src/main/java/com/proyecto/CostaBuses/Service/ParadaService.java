package com.proyecto.CostaBuses.Service;

import com.proyecto.CostaBuses.Model.Parada;
import com.proyecto.CostaBuses.Model.SeguridadValores;
import com.proyecto.CostaBuses.Model.dto.ParadaDto;
import com.proyecto.CostaBuses.Model.dto.RutaDto;
import com.proyecto.CostaBuses.Repository.ParadaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParadaService
{
    @Autowired
    ParadaJpaRepository paradaJpaRepository;

    public List<Parada> findAll()
    {
        return paradaJpaRepository.findAll();
    }

    public Parada getById(String id)
    {
        boolean existParada = paradaJpaRepository.existsById(id);
        if (existParada)
        {
            return  paradaJpaRepository.getById(id);
        }
        return null;
    }

    public Parada add(ParadaDto paradaDto, String id)
    {
        Optional<Parada> paradaExist = paradaJpaRepository.findById(id);
        if(paradaExist.isPresent())
        {
            return null;
        }
        if(paradaDto.getNombre()== null || paradaDto.getUbicacion()== null)
        {
           return null;
        }
        Parada parada = new Parada();
        parada.setNombre(parada.getNombre());
        parada.setUbicacion(parada.getUbicacion());
        parada.setSeguridad(String.valueOf(SeguridadValores.media));
        return paradaJpaRepository.save(parada);

    }

    public Parada update(ParadaDto dto, String id)
    {
        Optional<Parada> paradaExist = paradaJpaRepository.findById(id);
        if(paradaExist.isPresent())
        {
            Parada parada = paradaExist.get();
            if(dto.getNombre() != null)
            {
                parada.setNombre(dto.getNombre());
            }
            if (dto.getUbicacion() != null)
            {
                parada.setUbicacion(dto.getUbicacion());
            }
            return paradaJpaRepository.save(parada);
        }
        return null;
    }

    public Parada delete(String id)
    {
        Parada paradaExist = paradaJpaRepository.getById(id);
        if(paradaExist != null)
        {
             paradaJpaRepository.deleteById(id);
             return  paradaExist;
        }
        return null;
    }

    public Parada changeName(String id, String newNombre )
    {
        Optional<Parada> paradaExist = paradaJpaRepository.findById(id);
        if(paradaExist.isPresent())
        {
            Parada parada = paradaExist.get();

            parada.setNombre(newNombre);

            return paradaJpaRepository.save(parada);
        }
        return null;
    }



}
