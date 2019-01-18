package br.pucminas.orderingmicroservice.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.orderingmicroservice.api.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
