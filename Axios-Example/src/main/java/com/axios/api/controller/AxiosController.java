package com.axios.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axios.api.model.Product;
import com.axios.api.repository.AxiosRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*")

public class AxiosController {
	
	@Autowired
	AxiosRepository axiosRepository;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product)
	{
		Product saveProduct = axiosRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED)
				.header("save","savedsuccessfully")
				.body("save");
	}
	@GetMapping("/getProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = axiosRepository.findAll();
		return ResponseEntity.ok(products);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		axiosRepository.existsById(id);
        axiosRepository.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully.");

}
	
	

}
