package ordermanagement.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            OrderRepository orderRepository
    ){
        return args -> {
            Orders firstOrder = new Orders(
                    1,
                    "shipping address",
                    "billing address",
                    105.60,
                    LocalDateTime.now()
            );

            Orders secOrder = new Orders(
                    2,
                    "shipping address2",
                    "billing address2",
                    6.60,
                    LocalDateTime.now()
            );

            //save to database
            orderRepository.saveAll(List.of(firstOrder, secOrder));
        };
    }
}
