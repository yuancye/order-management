package ordermanagement.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// data access layer
public interface OrderRepository
        extends JpaRepository<Orders, Integer> {

//    @Query("SELECT o FROM Orders o Where o.id = ?")
    Optional<Orders> findOrdersByOrderId(Integer orderId);
}
