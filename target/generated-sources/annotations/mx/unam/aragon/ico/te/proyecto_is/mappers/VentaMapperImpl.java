package mx.unam.aragon.ico.te.proyecto_is.mappers;

import javax.annotation.processing.Generated;
import mx.unam.aragon.ico.te.proyecto_is.dtos.VentaUpdateDto;
import mx.unam.aragon.ico.te.proyecto_is.entities.Venta;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-25T23:07:23-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Homebrew)"
)
@Component
public class VentaMapperImpl implements VentaMapper {

    @Override
    public void updateVentaFromDto(VentaUpdateDto dto, Venta target) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCliente() != null ) {
            target.setCliente( dto.getCliente() );
        }
        if ( dto.getProducto() != null ) {
            target.setProducto( dto.getProducto() );
        }
        if ( dto.getCantidad() != null ) {
            target.setCantidad( dto.getCantidad() );
        }
        if ( dto.getPrecio() != null ) {
            target.setPrecio( dto.getPrecio() );
        }
        if ( dto.getCosto() != null ) {
            target.setCosto( dto.getCosto() );
        }
        if ( dto.getSucursal() != null ) {
            target.setSucursal( dto.getSucursal() );
        }
        if ( dto.getEstado() != null ) {
            target.setEstado( dto.getEstado() );
        }
        if ( dto.getFechaVenta() != null ) {
            target.setFechaVenta( dto.getFechaVenta() );
        }
    }
}
