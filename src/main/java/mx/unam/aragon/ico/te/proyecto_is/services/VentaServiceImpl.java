package mx.unam.aragon.ico.te.proyecto_is.services;

import mx.unam.aragon.ico.te.proyecto_is.dtos.VentaUpdateDto;
import mx.unam.aragon.ico.te.proyecto_is.entities.Venta;
import mx.unam.aragon.ico.te.proyecto_is.mappers.VentaMapper;
import mx.unam.aragon.ico.te.proyecto_is.repositories.VentaRepository;
import mx.unam.aragon.ico.te.proyecto_is.services.iterfaces.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentaMapper ventaMapper;


    @Override
    public Iterable<Venta> findAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta findVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Long id, Venta venta) {
        Optional<Venta> oldVenta = ventaRepository.findById(id);
        if (oldVenta.isPresent()) {
            Venta newVenta = oldVenta.get();
            newVenta.setCantidad(venta.getCantidad());
            newVenta.setCliente(venta.getCliente());
            newVenta.setCosto(venta.getCosto());
            newVenta.setEstado(venta.getEstado());
            newVenta.setFechaVenta(venta.getFechaVenta());
            newVenta.setPrecio(venta.getPrecio());
            newVenta.setProducto(venta.getProducto());
            newVenta.setSucursal(venta.getSucursal());
            return ventaRepository.save(newVenta);
        }
        return null;
    }

    @Override
    public Venta updateParcial(Long id, VentaUpdateDto dto) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        ventaMapper.updateVentaFromDto(dto, venta);

        return ventaRepository.save(venta);
    }

    @Override
    public void deleteVentaById(Long id) {
        ventaRepository.deleteById(id);
    }
}
