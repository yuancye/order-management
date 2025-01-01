package ordermanagement.order;

import jakarta.persistence.*;


import java.time.LocalDateTime;

// model class, for simplify, only include partial informations
@Entity // hibernate
@Table(name = "Orders")
public class Orders {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
     )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    private Integer orderId;
    private Integer customerId;
    private String shippingAddress;
    private String billingAddress;
    private Double totalAmount;
    private LocalDateTime orderDate;

    public Orders() {
    }


    public Orders(Integer orderId, int customerId, String shippingAddress, String billingAddress, Double totalAmount, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public Orders(int customerId,
                  String shippingAddress,
                  String billingAddress,
                  double totalAmount,
                  LocalDateTime orderDate) {
        this.customerId = customerId;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }


    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                '}';
    }
}
