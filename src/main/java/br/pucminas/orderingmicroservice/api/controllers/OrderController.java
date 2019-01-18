package br.pucminas.orderingmicroservice.api.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.orderingmicroservice.api.Response;
import br.pucminas.orderingmicroservice.api.dtos.OrderDTO;
import br.pucminas.orderingmicroservice.api.dtos.SimpleOrderDTO;
import br.pucminas.orderingmicroservice.api.entities.Order;
import br.pucminas.orderingmicroservice.api.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "orders", description = "Recurso para gerenciamento de pedidos", tags={ "orders"})
public class OrderController 
{
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value = "Recupera todos os pedidos existentes", nickname = "findAllOrders", notes = "", tags={ "orders"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		   				@ApiResponse(code = 404, message = "Nenhum pedido foi encontrado na base de dados!") })
	@GetMapping(value ="/orders", produces = "application/json")
	public ResponseEntity<Response<List<SimpleOrderDTO>>> findAllOrders()
	{
		Response<List<SimpleOrderDTO>> response = new Response<List<SimpleOrderDTO>>();
		log.info("Buscando todos os pedidos existentes na base de dados!");
		List<Order> pedidos = orderService.findAll();

		if (pedidos.isEmpty()) {
			log.info("Nenhum pedido foi encontrado na base de dados!");
			response.getErrors().add("Nenhum usuário foi encontrado na base de dados!");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}

		response.setData(Order.convertToDTO(pedidos));
		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Consulta dados de um pedido especifico", nickname = "findOrderById", notes = "", tags={ "orders"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 404, message = "Não foi encontrado nenhum pedido")})
	@GetMapping(value = "/orders/{orderId}", produces = "application/json")
	public ResponseEntity<Response<OrderDTO>> findOrderById(@ApiParam(value = "Identificador do pedido a ser consultado", required = true) @PathVariable("orderId") Long orderId)
	{
		Response<OrderDTO> response = new Response<OrderDTO>();
		
		log.info("Consultando pedido na base de dados: {} " +orderId);
		Optional<Order> order = orderService.findById(orderId);
		

		if (!order.isPresent()) {
			log.info("Nenhum pedido foi encontrado para o orderId: {}" + orderId);
			response.getErrors().add("Nenhum pedido foi encontrado para o orderId" + orderId);
			
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(Order.convertToDTO(order.get()));
			
		return ResponseEntity.ok(response);
	}
}
