package com.Magazine.entity;

import javax.persistence.*;

@Entity
@Table(name = "OrderHistoryProduct")
public class OrderHistoryProduct{
    @Id
    @Column(name = "order_history_id")
    private long orderHistoryId;
    @ManyToOne(optional=false, cascade=CascadeType.DETACH)
    @JoinColumn (name="order_id")
    private OrderHistory orderHistory;
    @ManyToOne(optional=false, cascade=CascadeType.DETACH)
    @JoinColumn (name="article")
    private Product product;
public OrderHistoryProduct(){}

    public long getOrderHistoryId() {
        return orderHistoryId;
    }

    public void setOrderHistoryId(long orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
