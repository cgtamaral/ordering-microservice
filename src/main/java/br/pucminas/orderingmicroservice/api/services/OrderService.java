package br.pucminas.orderingmicroservice.api.services;

import java.util.List;
import java.util.Optional;

import br.pucminas.orderingmicroservice.api.entities.Order;

public interface OrderService {
	
	/**
	 * Retorna uma listagem de todos os pedidos existentes na base de dados.
	 * 
	 * @return List<Favorite>
	 */
	List<Order> findAll();

	/**
	 * Retorna as informações de um pedido conforme identificador passado como parâmetro.
	 * 
	 * @return Optional<Favorite>
	 */
	Optional<Order> findById(Long orderId);
}
