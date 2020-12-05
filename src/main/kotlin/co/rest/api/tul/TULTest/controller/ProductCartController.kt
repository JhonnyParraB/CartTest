package co.rest.api.tul.TULTest.controller

import org.springframework.web.bind.annotation.PutMapping
import co.rest.api.tul.TULTest.repository.ProductRepository
import co.rest.api.tul.TULTest.repository.ProductCartRepository
import co.rest.api.tul.TULTest.repository.CartRepository
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import co.rest.api.tul.TULTest.model.Cart
import org.springframework.http.ResponseEntity
import co.rest.api.tul.TULTest.model.ProductCart
import org.springframework.http.HttpStatus
import java.lang.Exception
import javassist.NotFoundException
import co.rest.api.tul.TULTest.model.Product
import org.springframework.web.bind.annotation.DeleteMapping


@RestController
class ProductCartController (
	private val productCartRepository: ProductCartRepository,
	private val cartRepository: CartRepository,
	private val productRepository: ProductRepository
){
	@PutMapping("/productcart/{cartId}/{productId}")
	fun addProductToCart(@PathVariable cartId: Long, @PathVariable productId: Long): ResponseEntity<Any>{
		val cart: Cart? = cartRepository.findById(cartId).orElse(null)
		val product: Product? = productRepository.findById(productId).orElse(null)
		
		if (cart == null || product == null){
			return ResponseEntity<Any>(null, HttpStatus.NOT_FOUND)
		}
		else{
			var productCart: ProductCart = ProductCart(0, product, cart)
			println(productCart.quantity)
			productCart = productCartRepository.save(productCart)
			return (ResponseEntity<Any>(productCart, HttpStatus.CREATED))
		}
	}
		
	@DeleteMapping("/productcart/{productCartId}")
	fun deleteProductCart(@PathVariable productCartId: Long): ResponseEntity<Any>{
		val productCart: ProductCart? = productCartRepository.findById(productCartId).orElse(null)
				
		if (productCart == null){
			return ResponseEntity<Any>(null, HttpStatus.NOT_FOUND)
		}
		else{
			productCartRepository.delete(productCart)
			return (ResponseEntity<Any>(productCart, HttpStatus.OK))
		}
	}
	
	@PutMapping("/productcart/{productCartId}/quantity/{quantity}")
	fun modifyProductCart(@PathVariable productCartId: Long, @PathVariable quantity: Long): ResponseEntity<Any>{
		var productCart: ProductCart? = productCartRepository.findById(productCartId).orElse(null)
				
		if (productCart == null){
			return ResponseEntity<Any>(null, HttpStatus.NOT_FOUND)
		}
		else{
			productCart.quantity = quantity
			productCartRepository.save(productCart)
			return (ResponseEntity<Any>(productCart, HttpStatus.OK))
		}
	}
}