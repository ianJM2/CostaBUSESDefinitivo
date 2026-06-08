package com.proyecto.CostaBuses.Service;

import com.proyecto.CostaBuses.Model.Ruta;
import com.proyecto.CostaBuses.Model.dto.RutaDto;
import com.proyecto.CostaBuses.Repository.RutaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService
{
    @Autowired
    private RutaJpaRepository rutaJpaRepository;

    public List<Ruta> findAll()
    {
        return rutaJpaRepository.findAll();
    }

    public Ruta findByCodigo (String codigo)
    {
        if(rutaJpaRepository.existsByCodigo(codigo))
        {
            rutaJpaRepository.getByCodigo(codigo);
        }
        return null;
    }

    public Ruta add(RutaDto rutaDto)
    {
        Optional<Ruta> rutaExists = rutaJpaRepository.findByCodigo(rutaDto.getCodigo());
        if(rutaExists.isPresent())
        {
            return null;
        }
        if(rutaDto.getCodigo() == null || rutaDto.getDestino() == null || rutaDto.getOrigen() == null)
        {
            return null;
        }
        Ruta rutaN = new Ruta();

        rutaN.setCodigo(rutaDto.getCodigo());
        rutaN.setOrigen(rutaDto.getOrigen());
        rutaN.setDestino(rutaDto.getDestino());

        return rutaJpaRepository.save(rutaN);
    }

    public Ruta update(RutaDto rutaDto)
    {
        Optional<Ruta> rutaExists = rutaJpaRepository.findByCodigo(rutaDto.getCodigo());
        if(rutaExists.isPresent())
        {
            Ruta rutaN = rutaExists.get();

            if(rutaDto.getOrigen() != null)
            {
                rutaN.setOrigen(rutaDto.getOrigen());
            }
            if (rutaDto.getDestino() != null)
            {
                rutaN.setDestino(rutaDto.getDestino());
            }
            if(rutaDto.getCodigo() != null)
            {
                rutaN.setCodigo(rutaDto.getCodigo());
            }

            return rutaJpaRepository.save(rutaN);

        }
        return null;
    }

    public Ruta changeOrigen(String codigo,String origen)
    {
        Optional<Ruta> rutaExists = rutaJpaRepository.findByCodigo(codigo);
        if(rutaExists.isPresent())
        {
            Ruta rutaN = rutaExists.get();
            rutaN.setOrigen(origen);

            rutaJpaRepository.save(rutaN);
        }
        return null;
    }

    public Ruta changeDestino(String codigo,String destino)
    {
        Optional<Ruta> rutaExists = rutaJpaRepository.findByCodigo(codigo);
        if(rutaExists.isPresent())
        {
            Ruta rutaN = rutaExists.get();
            rutaN.setDestino(destino);

            rutaJpaRepository.save(rutaN);
        }
        return null;
    }

    public Ruta delete(String codigo)
    {
        Optional<Ruta> rutaExists = rutaJpaRepository.findByCodigo(codigo);
        if(rutaExists.isPresent())
        {
            Ruta rutaN = rutaExists.get();
            return rutaJpaRepository.deleteByCodigo(codigo);
        }
        return null;
    }

    public Ruta getByCodigo(String codigo)
    {
        return rutaJpaRepository.getByCodigo(codigo);
    }

}
