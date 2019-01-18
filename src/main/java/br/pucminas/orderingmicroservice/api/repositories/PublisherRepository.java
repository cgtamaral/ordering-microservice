package br.pucminas.orderingmicroservice.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.orderingmicroservice.api.entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
