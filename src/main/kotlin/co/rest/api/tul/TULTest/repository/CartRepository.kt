package co.rest.api.tul.TULTest.repository

import co.rest.api.tul.TULTest.model.Cart
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface CartRepository : JpaRepository<Cart, Long> {
}