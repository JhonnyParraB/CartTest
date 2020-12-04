package co.rest.api.tul.TULTest.repository

import org.springframework.stereotype.Repository
import co.rest.api.tul.TULTest.model.Product
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {	
}