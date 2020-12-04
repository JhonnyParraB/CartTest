package co.rest.api.tul.TULTest.controller

import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.GetMapping
import co.rest.api.tul.TULTest.model.Product
import co.rest.api.tul.TULTest.repository.ProductRepository
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController (
	private val productRepository: ProductRepository
){
	@GetMapping("/products")
	fun getProducts() = productRepository.findAll()
}