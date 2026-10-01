package repository;

import enums.EstadoDelPedido;
import models.MPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<MPedido, Integer> {
    List<MPedido> encontrarClientePorId(int id);
    List<MPedido> encontrarPedidosPorEstado(EstadoDelPedido estadoPedido);

}
