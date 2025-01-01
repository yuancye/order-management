package ordermanagement.order;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

// service layer, business logical
@Service // one type of component, annotation, spring boot can manage the life cycle of this component
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> getOrders(){
        return orderRepository.findAll();
    }

    public Orders getOrderByOrderId(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order " + orderId + " does not exist"));
    }

    public void addNewOrder(Orders order){
        Optional<Orders> orderByOrderId = orderRepository.findOrdersByOrderId(order.getOrderId());
        if (orderByOrderId.isPresent()) {
            throw new IllegalStateException("Order already exists");
        }
        orderRepository.save(order);
    }

    public void deleteOrderByOrderId(Integer orderId){
        boolean exists = orderRepository.existsById(orderId);
        if (!exists) {
            throw new IllegalStateException("Order " + orderId + " does not exist");
        }
        orderRepository.deleteById(orderId);
    }

    @Transactional //use model's setter to update the field
    public void updateOrderOfBillingAddress(Integer orderId, String billingAddress) {
        Orders order= orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order " + orderId + " does not exist"));

        if (billingAddress != null && !billingAddress.isEmpty()
        && !billingAddress.equals(order.getBillingAddress())) {
            order.setBillingAddress(billingAddress);
        }
    }
}
