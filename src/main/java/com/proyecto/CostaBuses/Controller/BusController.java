package com.proyecto.CostaBuses.Controller;

import com.proyecto.CostaBuses.Model.Bus;
import com.proyecto.CostaBuses.Model.dto.BusDto;
import com.proyecto.CostaBuses.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController
{
    @Autowired
   private BusService busService;

    @GetMapping("/all")
    public ResponseEntity<List<?>> findAll() {
        List<Bus> spaces = busService.findAll();
        if (spaces.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(busService.findAll());
    }

    @GetMapping("/{placa}")
    public ResponseEntity<?> getByPlaca(@PathVariable String placa) {
        Bus bus = busService.getByPlaca(placa);
        if (bus == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bus);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody BusDto bus) {
        if (busService.add(bus) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El espacio ya está registrado o faltan campos obligatorios");
        }
        return ResponseEntity.ok("bus registrado exitosamente");
    }

    @PutMapping("/{placa}")
    public ResponseEntity<?> update(@PathVariable String placa, @RequestBody BusDto bus) {
        if (busService.update(bus) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("bus actualizado exitosamente");
    }

    @DeleteMapping({"/{placa}"})
    public ResponseEntity<?> delete(@PathVariable String placa) {

        if (busService.delete(placa) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("bus eliminado exitosamente");
    }

    @PatchMapping("/change/{placa}")
    public ResponseEntity<?> cambioDeconductor(@PathVariable String placa, @RequestBody Bus bus) {
        if (busService.cambioDeConductor(placa, bus.getConductor()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("conductor cambiado ");
    }
}
