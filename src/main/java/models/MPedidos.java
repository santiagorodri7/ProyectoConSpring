package models;
import enums.EstadoDelPedido;
import java.time.LocalDateTime;

public class MPedidos {
    private int id;
    private MCliente cliente;
    private String descripcion;
    private double precioNeto;
    private EstadoDelPedido estadoPedido;
    private LocalDateTime fechaDelPedido;

}
