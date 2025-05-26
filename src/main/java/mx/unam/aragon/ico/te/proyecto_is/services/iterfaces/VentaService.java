package mx.unam.aragon.ico.te.proyecto_is.services.iterfaces;

import mx.unam.aragon.ico.te.proyecto_is.dtos.VentaUpdateDto;
import mx.unam.aragon.ico.te.proyecto_is.entities.Venta;

public interface VentaService {

    public abstract Iterable<Venta> findAllVentas();
    public abstract Venta findVentaById(Long id);
    public abstract Venta createVenta(Venta venta);
    public abstract Venta updateVenta(Long id, Venta venta);
    public abstract Venta updateParcial(Long id, VentaUpdateDto dto);
    public abstract void deleteVentaById(Long id);

}
