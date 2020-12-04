package co.rest.api.tul.TULTest.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "product_carts")
data class ProductCart (
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long,
	@ManyToOne
	var product: Product,
	@ManyToOne
	@JsonIgnore
	var cart: Cart,
	var quantity: Long = 1
		) {
}