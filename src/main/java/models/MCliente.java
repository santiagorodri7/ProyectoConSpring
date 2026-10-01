package models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cliente") // Se recomienda nombrar la tabla en minúsculas y singular
public class MCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 40)
    private String nombre;

    @Column(nullable = false, unique = true, length = 50)
    private String correo;

    @Column(length = 60)
    private String telefono;

    @Column(length = 50)
    private String dirreccion;

    @Column(nullable = false, updatable = false, name = "fecha_de_registro")
    private LocalDateTime fechaDeRegistro;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MPedido> pedidos;

    // CONSTRUCTOR VACÍO OBLIGATORIO PARA JPA
    public MCliente() {
    }

    public MCliente(List<MPedido> pedidos, LocalDateTime fechaDeRegistro, String dirreccion, String nombre, String correo, String telefono) {
        this.pedidos = pedidos;
        this.fechaDeRegistro = fechaDeRegistro;
        this.dirreccion = dirreccion;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // GETTERS Y SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDirreccion() { return dirreccion; }
    public void setDirreccion(String dirreccion) { this.dirreccion = dirreccion; }

    public LocalDateTime getFechaDeRegistro() { return fechaDeRegistro; }
    public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) { this.fechaDeRegistro = fechaDeRegistro; }

    public List<MPedido> getPedidos() { return pedidos; }
    public void setPedidos(List<MPedido> pedidos) { this.pedidos = pedidos; }
}