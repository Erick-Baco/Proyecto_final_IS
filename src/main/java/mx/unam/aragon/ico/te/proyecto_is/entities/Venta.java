package mx.unam.aragon.ico.te.proyecto_is.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "cliente",
            columnDefinition = "VARCHAR(100) NOT NULL"
    )
    @NotBlank(message = "Campo no puede se puede enviar en blanco")
    private String cliente;

    @Column( name = "producto",
            columnDefinition = "VARCHAR(20) NOT NULL"
    )
    @NotBlank(message = "Campo no puede se puede enviar en blanco")
    private String producto;

    @Column( name = "cantidad",
            columnDefinition = "INT NOT NULL"
    )
    private Integer cantidad;

    @Column( name = "precio",
            columnDefinition = "FLOAT NOT NULL"
    )
    private Float precio;

    @Column( name = "costo",
            columnDefinition = "FLOAT NOT NULL"
    )
    private Float costo;

    @Column( name = "sucursal",
            columnDefinition = "VARCHAR(100) NOT NULL"
    )
    @NotBlank(message = "Campo no puede se puede enviar en blanco")
    private String sucursal;

    @Column( name = "estado",
            columnDefinition = "VARCHAR(1) NOT NULL"
    )
    @NotBlank(message = "Campo no puede se puede enviar en blanco")
    private String estado;

    @Column(name = "fechaVenta", nullable = false)
    private LocalDateTime fechaVenta;


    @Column( name = "fechaCreacion",
            nullable = false
    )
    private LocalDateTime fechaCreacion;

    @Column( name = "fechaModificacion",
            nullable = false
    )
    private LocalDateTime fechaModificacion;

    public Venta() {
    }

    public Venta(String cliente, String producto, Integer cantidad, Float precio, Float costo, String sucursal, String estado) {

        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.costo = costo;
        this.sucursal = sucursal;
        this.estado = estado;
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.fechaVenta = now;
        this.fechaCreacion = now;
        this.fechaModificacion = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
