package mx.unam.aragon.ico.te.proyecto_is;

import mx.unam.aragon.ico.te.proyecto_is.dtos.VentaUpdateDto;
import mx.unam.aragon.ico.te.proyecto_is.entities.Venta;
import mx.unam.aragon.ico.te.proyecto_is.repositories.VentaRepository;
import mx.unam.aragon.ico.te.proyecto_is.services.VentaServiceImpl;
import mx.unam.aragon.ico.te.proyecto_is.services.iterfaces.VentaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProyectoIsApplicationTests {

//    @Autowired
//    private VentaRepository ventaRepository;
//
//    @Autowired
//    private VentaService ventaService;

//    @Test
//    void contextLoads() {
//    }

//    @Test
//    void createVenta() {
//        Venta venta = new Venta( "Marta", "Laptop", "1", 11149.99F, 8000.00F, "FES Aragon", "1"  );
//        ventaRepository.save(venta);
//    }
//
//    @Test
//    void getById() {
//        long id = 1L;
//        Optional<Venta> venta = ventaRepository.findById(id);
//        System.out.println(venta.toString());
//    }
//
//    @Test
//    void getAll() {
//        Iterable<Venta> ventas = ventaRepository.findAll();
//
//        int size = 0;
//        for (Venta venta : ventas) {
//            size++;
//        }
//        System.out.println(size);
//    }
//
//    @Test
//    void testUpdateClienteParcial() {
//
//        VentaUpdateDto dto = new VentaUpdateDto();
//        dto.setCliente("Erick");
//
//
//        Venta actualizada = ventaService.updateParcial(1L, dto);
//
//    }
//
//    @Test
//    void updateVentaTest() {
//        Venta tmp = ventaRepository.findVentaById(1L);
//        tmp.setCliente("Cliente Parcial");
//        ventaRepository.save(tmp);
//    }
//
//    @Test
//    void delete() {
//        ventaRepository.deleteById(3L);
//    }
}
