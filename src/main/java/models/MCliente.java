package models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

public class MCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = false, length = 40)
    private String nombre;
    @Column(nullable = false, unique = true, length = 50)
    private String correo;
    @Column(nullable = true, unique = false, length = 60)
    private String telefono;
    @Column(nullable = true, unique = false, length = 50)
    private String dirreccion;
    @Column(nullable = false, updatable = false, name = "fecha_de_registro")
    private LocalDateTime fechaDeRegistro;

    private List<MPedidos> pedidos;

    public MCliente(List<MPedidos> pedidos, LocalDateTime fechaDeRegistro, String dirreccion, String nombre, String correo, String telefono) {
        this.pedidos = pedidos;
        this.fechaDeRegistro = fechaDeRegistro;
        this.dirreccion = dirreccion;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
}
