package br.pucminas.orderingmicroservice.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pucminas.orderingmicroservice.api.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> 
{
	
}
