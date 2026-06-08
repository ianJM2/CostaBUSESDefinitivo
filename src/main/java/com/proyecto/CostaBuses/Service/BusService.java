package com.proyecto.CostaBuses.Service;

import com.proyecto.CostaBuses.Model.Bus;
import com.proyecto.CostaBuses.Model.Usuario;
import com.proyecto.CostaBuses.Model.dto.BusDto;
import com.proyecto.CostaBuses.Repository.BusJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusJpaRepository busJpaRepository;

    public List<Bus> findAll() {
        return busJpaRepository.findAll();
    }

    public Bus getByPlaca(String placa) {
        if (busJpaRepository.existsByPlaca(placa)) {
            return busJpaRepository.getByPlaca(placa);
        }
        return null;
    }

    public Bus add(BusDto busDto) {
        Optional<Bus> busExist = busJpaRepository.findByPlaca(busDto.getPlaca());
        if (busExist.isPresent()) {
            return null;
        } else {
            if (busDto.getCapacidad() == null || busDto.getConductor() == null || busDto.getModelo() == null ) {
                return null;
            }
        }

        Bus busTemp = new Bus();
        busTemp.setPlaca(busDto.getPlaca());
        busTemp.setModelo(busDto.getModelo());
        busTemp.setCapacidad(busDto.getCapacidad());
        busTemp.setConductor(busDto.getConductor());

        return busJpaRepository.save(busTemp);

    }

    public Bus update(BusDto bus) {
        Optional<Bus> busExits = busJpaRepository.findByPlaca(bus.getPlaca());

        if (busExits.isPresent()) {
            Bus busN = busExits.get();

            if (bus.getModelo() != null) {
                busN.setModelo(bus.getModelo());
            }
            if (bus.getConductor() != null) {
                busN.setConductor(bus.getConductor());
            }
            if (bus.getCapacidad() != null) {
                busN.setCapacidad(bus.getCapacidad());
            }
            if (bus.getPlaca() !=null)
            {
                busN.setPlaca(bus.getPlaca());
            }

            return busJpaRepository.save(busN);
        } else {
            return null;
        }


    }

    public Bus delete(String placa) {
        Optional<Bus> busExits = busJpaRepository.findByPlaca(placa);
        if (busExits.isPresent()) {
             busJpaRepository.deleteByPlaca(placa);
            return busExits.get();
        }
        return null;
    }

    public Bus cambioDeConductor(String placa, String conductor) {
        Optional<Bus> busExist = busJpaRepository.findByPlaca(placa);
        if (busExist.isPresent()) {
            Bus bus = busExist.get();
            bus.setConductor(conductor);

            return busJpaRepository.save(bus);
        }
        return null;
    }




}