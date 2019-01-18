package br.pucminas.orderingmicroservice.api.services;

import java.util.Optional;

import br.pucminas.orderingmicroservice.api.entities.Customer;

public interface CustomerService {
	
	/**
	 * Retorna um Cliente existente na base de dados conforme identificador informado via parâmetro.
	 * 
	 * @return Optional<Customer>
	 */
	Optional<Customer> findById(Long customerId);

}
