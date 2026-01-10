package com.trenvios.trabajoenvios.repository;

import com.trenvios.trabajoenvios.model.Pedido;
import jakarta.persistence.Enumerated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido,Long> {
}
