package repository;

import models.MCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<MCliente, Integer> {
    Optional<MCliente> findByCorreo(String correo);


}
