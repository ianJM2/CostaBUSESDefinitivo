package com.proyecto.CostaBuses.Controller;

import com.proyecto.CostaBuses.Model.Bus;
import com.proyecto.CostaBuses.Model.Ruta;
import com.proyecto.CostaBuses.Model.dto.BusDto;
import com.proyecto.CostaBuses.Model.dto.RutaDto;
import com.proyecto.CostaBuses.Service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ruta")
public class RutaController
{
    @Autowired
    RutaService rutaService;

    @GetMapping("/all")
    public ResponseEntity<List<?>> findAll()
    {
        List<Ruta> ruta = rutaService.findAll();
        if(ruta.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rutaService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> getByCodigo(@PathVariable String codigo) {
        Ruta ruta = rutaService.getByCodigo(codigo);
        if (ruta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ruta);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody RutaDto rutaDto) {
        if (rutaService.add(rutaDto) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El espacio ya está registrado o faltan campos obligatorios");
        }
        return ResponseEntity.ok("ruta registrada exitosamente");
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> update(@PathVariable String codigo, @RequestBody RutaDto rutaDto) {
        if (rutaService.update(rutaDto) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("ruta actualizada exitosamente");
    }

    @DeleteMapping({"/{codigo}"})
    public ResponseEntity<?> delete(@PathVariable String codigo) {

        if (rutaService.delete(codigo) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("ruta eliminada exitosamente");
    }

    @PatchMapping("/changeOrigen/{codigo}")
    public ResponseEntity<?> changeOrigen(@PathVariable String codigo, @RequestBody Ruta ruta) {
        if (rutaService.changeOrigen(codigo, ruta.getOrigen()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Origen cambiado cambiado ");
    }

    @PatchMapping("/changeDestino/{codigo}")
    public ResponseEntity<?> changeDestino(@PathVariable String codigo, @RequestBody Ruta ruta) {
        if (rutaService.changeDestino(codigo, ruta.getDestino()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Origen cambiado cambiado ");
    }


}
