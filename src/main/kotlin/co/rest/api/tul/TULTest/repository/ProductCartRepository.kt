package co.rest.api.tul.TULTest.repository

import org.springframework.stereotype.Repository
import co.rest.api.tul.TULTest.model.ProductCart
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface ProductCartRepository : JpaRepository<ProductCart, Long> {
}