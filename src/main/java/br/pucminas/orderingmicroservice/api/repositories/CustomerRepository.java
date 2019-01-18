package br.pucminas.orderingmicroservice.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.orderingmicroservice.api.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
