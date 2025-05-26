package mx.unam.aragon.ico.te.proyecto_is.repositories;

import mx.unam.aragon.ico.te.proyecto_is.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    Venta findVentaById(Long id);
    Venta deleteVentaById(Long id);

}
