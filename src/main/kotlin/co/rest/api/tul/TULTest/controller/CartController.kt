package co.rest.api.tul.TULTest.controller

import co.rest.api.tul.TULTest.repository.CartRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import co.rest.api.tul.TULTest.model.Cart
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import co.rest.api.tul.TULTest.model.enums.CartStatus
import org.springframework.web.bind.annotation.GetMapping

@RestController
class CartController (
	private val cartRepository: CartRepository
){
	@GetMapping("/cart/{cartId}")
	fun getCart(@PathVariable cartId: Long) : ResponseEntity<Any>{
		val cart: Cart? = cartRepository.findById(cartId).orElse(null)
		if(cart == null)
			return ResponseEntity<Any>(null, HttpStatus.NOT_FOUND)
		else
			return ResponseEntity<Any>(cart, HttpStatus.OK);
	}
	
	@PostMapping("/cart/{cartId}/checkout")
	fun checkoutCart(@PathVariable cartId: Long): ResponseEntity<Any>{
		var cart: Cart? = cartRepository.findById(cartId).orElse(null)
		if (cart == null){
			return ResponseEntity<Any>(null, HttpStatus.NOT_FOUND)
		}
		else{
			cart.status = CartStatus.COMPLETED
			cartRepository.save(cart)
			return ResponseEntity<Any>(null, HttpStatus.OK)
		}
	}
}