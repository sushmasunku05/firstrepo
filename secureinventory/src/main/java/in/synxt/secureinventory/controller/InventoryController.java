package in.synxt.secureinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.synxt.secureinventory.entities.InventoryUsers;
import in.synxt.secureinventory.service.InventoryUserService;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryUserService userService;
	
	@Autowired
	Environment env;
	
	@GetMapping("/public/appinfo")
	public String getAppInfo() {
		return "This is related to app information" +env.getProperty("local.server.port");
	}
	
	@GetMapping("/public/customerinfo")
	public String getCustomerInfo() {
		return "Please contact customer care for more info";
	}
	
	@GetMapping("/secure/productinfo")
	public String getProductInfo() {
		return "Product related information";
	}
	
	@GetMapping("/secure/products/{productId}")
	public String getProductById(@PathVariable int productId) {
		return "product is present"+productId;
	}
	
	@GetMapping(path="/public/user/{emailId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public InventoryUsers getUser(@PathVariable("emailId") String emailId) {
		return userService.loadUsername(emailId);
		
	}
	@PostMapping("/secure/products/{productId}")
	public String createProductById(@PathVariable int productId) {
		return "product is created" +productId;
	}
	
}
