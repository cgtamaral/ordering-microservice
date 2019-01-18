package br.pucminas.orderingmicroservice.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.orderingmicroservice.api.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
