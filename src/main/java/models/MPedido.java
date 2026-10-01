package models;

import enums.EstadoDelPedido;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class MPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private MCliente cliente;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false) // Se quitó length
    private Double precioNeto;

    @Enumerated(EnumType.STRING) // Indica que se guardará el texto del enum en la BD
    @Column(nullable = false, length = 20) // Aquí length especifica el tamaño de la columna VARCHAR del enum
    private EstadoDelPedido estadoPedido;

    @Column(nullable = false, name = "fecha_del_pedido") // Se quitó length
    private LocalDateTime fechaDelPedido;

    // CONSTRUCTOR VACÍO OBLIGATORIO PARA JPA
    public MPedido() {
    }

    public MPedido(MCliente cliente, String descripcion, double precioNeto, EstadoDelPedido estadoPedido, LocalDateTime fechaDelPedido) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.precioNeto = precioNeto;
        this.estadoPedido = estadoPedido;
        this.fechaDelPedido = fechaDelPedido;
    }

    // GETTERS Y SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public MCliente getCliente() { return cliente; }
    public void setCliente(MCliente cliente) { this.cliente = cliente; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecioNeto() { return precioNeto; }
    public void setPrecioNeto(double precioNeto) { this.precioNeto = precioNeto; }

    public EstadoDelPedido getEstadoPedido() { return estadoPedido; }
    public void setEstadoPedido(EstadoDelPedido estadoPedido) { this.estadoPedido = estadoPedido; }

    public LocalDateTime getFechaDelPedido() { return fechaDelPedido; }
    public void setFechaDelPedido(LocalDateTime fechaDelPedido) { this.fechaDelPedido = fechaDelPedido; }
}