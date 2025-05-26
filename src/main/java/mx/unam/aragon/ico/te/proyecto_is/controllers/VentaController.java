package mx.unam.aragon.ico.te.proyecto_is.controllers;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.te.proyecto_is.dtos.VentaUpdateDto;
import mx.unam.aragon.ico.te.proyecto_is.entities.Venta;
import mx.unam.aragon.ico.te.proyecto_is.services.iterfaces.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@Controller
@RequestMapping("api/ventas")
public class VentaController {

    @Autowired
    VentaService ventaService;

    private static String URI_LOCAL = "http://localhost:8080";

    @GetMapping("/")
    public ResponseEntity<Iterable<Venta>> findAllVentas() {
        return new ResponseEntity<>(ventaService.findAllVentas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> findVentaById(@PathVariable Long id) {
        return new ResponseEntity<>(ventaService.findVentaById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Venta> createVenta(@Valid @RequestBody Venta venta) throws URISyntaxException {
        return new ResponseEntity<>(ventaService.createVenta(venta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        return new ResponseEntity<>(ventaService.updateVenta(id, venta), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Venta> patchVenta(@PathVariable Long id, @RequestBody VentaUpdateDto venta) {
        return new ResponseEntity<>(ventaService.updateParcial(id, venta), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Venta> deleteVenta(@PathVariable Long id) {
        ventaService.deleteVentaById(id);
        return null;
    }

}
