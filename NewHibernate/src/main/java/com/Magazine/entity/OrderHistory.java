package com.Magazine.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "OrderHistory")
@NoArgsConstructor
@Builder
public class OrderHistory {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private long goodsQuantity;
    private Date date;
    private long cost;
    private long productDiscount;
    private long userDiscount;
    private long coupons;
    private long totalDiscount;
    private long totalCost;
    private boolean refund;
    @OneToMany (mappedBy="order")
    private List<User> users = new ArrayList<>();
    @OneToMany (mappedBy="product", fetch=FetchType.EAGER)
    private List<OrderHistoryProduct> orderHistoryProducts =new ArrayList<>();

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<OrderHistoryProduct> getOrderHistoryProducts() {
        return orderHistoryProducts;
    }

    public void setOrderHistoryProducts(List<OrderHistoryProduct> orderHistoryProducts) {
        this.orderHistoryProducts = orderHistoryProducts;
    }

    public long getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(long goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(long productDiscount) {
        this.productDiscount = productDiscount;
    }

    public long getUserDiscount() {
        return userDiscount;
    }

    public void setUserDiscount(long userDiscount) {
        this.userDiscount = userDiscount;
    }

    public long getCoupons() {
        return coupons;
    }

    public void setCoupons(long coupons) {
        this.coupons = coupons;
    }

    public long getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(long totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

}
