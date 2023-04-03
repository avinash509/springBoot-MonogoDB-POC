package Service.price.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import Service.price.api.model.Product;

@RestController
public class PriceController {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	static final String Product_URL="http://localhost:9091/v1/";
	
	@GetMapping("/price/{id}")
	public String fetchprice(@PathVariable int id) {
		ResponseEntity<Product> product=restTemplate.exchange(Product_URL+"product/"+id, HttpMethod.GET,null,Product.class);
		System.out.println("the price of each product" + product);
		return restTemplate.exchange(Product_URL+"product/"+id, HttpMethod.GET,null,String.class).getBody();
	}
	
}
