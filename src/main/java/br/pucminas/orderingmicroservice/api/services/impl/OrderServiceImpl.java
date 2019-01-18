package br.pucminas.orderingmicroservice.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucminas.orderingmicroservice.api.entities.Order;
import br.pucminas.orderingmicroservice.api.repositories.OrderRepository;
import br.pucminas.orderingmicroservice.api.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Order> findAll() {
		log.info("Buscando todos os usuários da base! {}");
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findById(Long orderId) {
		log.info("Buscando pedido: {}" + orderId);
		return orderRepository.findById(orderId);
	}

}
