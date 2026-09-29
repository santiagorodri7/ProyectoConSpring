package repository;

import enums.EstadoDelPedido;
import models.MPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<MPedidos, Integer> {
    List<MPedidos> encontrarClientePorId(int id);
    List<MPedidos> encontrarPedidosPorEstado(EstadoDelPedido estadoPedido);

}
