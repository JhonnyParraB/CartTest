package co.rest.api.tul.TULTest.model

import javax.persistence.*
import co.rest.api.tul.TULTest.model.enums.CartStatus

@Entity
@Table(name = "carts")
data class Cart (
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long,
	@Enumerated(EnumType.STRING)
	var status: CartStatus = CartStatus.PENDING,
	@OneToMany(mappedBy = "cart")
	var productCarts: List<ProductCart>){
	 
}