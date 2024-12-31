package ordermanagement;

import ordermanagement.order.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
// rest api
@RestController
public class OrderManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }


    @GetMapping
    public List<Order> hello(){
        return List.of(
                new Order(
                        1,
                        1,
                        "shipping address",
                        "billing address",
                        105.60,
                        LocalDateTime.now()
                )
        );
    }
}

