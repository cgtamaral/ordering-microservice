package br.pucminas.orderingmicroservice.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.orderingmicroservice.api.Response;
import br.pucminas.orderingmicroservice.api.dtos.OrderDTO;
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
	
	@ApiOperation(value = "Recupera todos os pedidos existentes", nickname = "findAllOrders", notes = "", tags={ "orders"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		   				@ApiResponse(code = 404, message = "Nenhum pedido foi encontrado na base de dados!") })
	@GetMapping(value ="/orders", produces = "application/json")
	public ResponseEntity<Response<List<OrderDTO>>> findAllOrders()
	{
		log.info("Buscando todos os pedidos existentes na base de dados!");
		Response<List<OrderDTO>> response = new Response<List<OrderDTO>>();
		
		List<OrderDTO> retornoFakeNull = new ArrayList<OrderDTO>();
		retornoFakeNull.add(new OrderDTO());
		response.setData(retornoFakeNull);

		
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value = "Insere um novo pedido", nickname = "insertOrder", notes = "", tags={ "orders"})
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Operação bem sucessida e um novo pedido foi incluido na base de dados"),
		    @ApiResponse(code = 400, message = "O objeto de request possui informações inválidas para a inclusão do pedido!"),
		    @ApiResponse(code = 404, message = "Registro não encontrado na base de dados!")})
	@PostMapping(value ="/orders", produces = "application/json")
	public ResponseEntity<Response<OrderDTO>> insertOrder(@ApiParam(value = "Objeto do pedido que precisa ser incluido na base de dados", required = true) @Valid @RequestBody OrderDTO orderDTO,  BindingResult result)
	{
		log.info("Incluindo novo pedido para o cliente{} " + (orderDTO!=null ? orderDTO.getCustomerId() : "?"));
		Response<OrderDTO> response = new Response<OrderDTO>();

		response.setData(new OrderDTO());
		
		return ResponseEntity.ok().body(response);
	}
}
