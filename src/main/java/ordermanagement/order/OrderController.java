package ordermanagement.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
// API controller, logical layer
@RestController
// api end point mapping
@RequestMapping(path="/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired // dependency injection, with this annotation, tells spring OrderService is a bean
    // it becomes the singleton?
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping(path = "{orderId}")
    public Orders getOrderById(@PathVariable("orderId") Integer orderId){
        return orderService.getOrderByOrderId(orderId);
    }

    @PostMapping
    public void saveOrder(@RequestBody Orders order){
        orderService.addNewOrder(order);
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Integer orderId){
        orderService.deleteOrderByOrderId(orderId);
    }

    @PutMapping(path = "{orderId}")
    public void updateOrder(@PathVariable("orderId") Integer orderId,
                            @RequestParam(required = false) String billingAddress){
        orderService.updateOrderOfBillingAddress(orderId, billingAddress);
    }

}
