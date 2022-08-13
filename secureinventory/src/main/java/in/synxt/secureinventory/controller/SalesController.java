package in.synxt.secureinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.synxt.core.ProductOrderModel;
import in.synxt.secureinventory.service.OrderService;

@RestController
@RequestMapping("/secure")
public class SalesController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping(path="/order",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ProductOrderModel orderProduct(@RequestBody ProductOrderModel order) {
		return orderService.orderProduct(order);
	}
	
	@GetMapping(path="/order/{orderId}")
	public ProductOrderModel getOrderById(@PathVariable("orderId")String orderId) {
		return orderService.getOrderDetails(orderId);
	}
}
