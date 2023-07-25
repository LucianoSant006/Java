package com.controlproduct.controlproduct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlproduct.controlproduct.domain.Product;
import com.controlproduct.controlproduct.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product createProduct = productService.createProduct(product);
		return new ResponseEntity<>(createProduct, HttpStatus.CREATED);	
	}
	
	@PutMapping("/up/{id}")
	public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody Product product){
		Optional<Product> existProduct =productService.getProductById(id);
		if (existProduct.isPresent()) {
			productService.updateProduct(id, product);
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/dl/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		Optional<Product> existProduct =productService.getProductById(id);
		if (existProduct.isPresent()) {
			productService.deleteProduct(id);
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

}
