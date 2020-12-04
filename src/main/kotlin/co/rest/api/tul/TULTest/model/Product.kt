package co.rest.api.tul.TULTest.model

import javax.persistence.*

@Entity
@Table(name = "products")
class Product (
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long,
	var nombre: String,
	var sku: String,
	var descripcion: String
){
}