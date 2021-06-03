package com.Magazine.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Basket")
public class Basket {
    @Id
    @Column(name = "basket_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long basketId;
    @Column(name = "cost")
    private long cost;
    @Column(name = "total_cost")
    private long totalCost;
    @Column(name = "qoods_quantity")
    private long qoodsQuantity;
    @OneToMany (mappedBy="basket")
    private List<BasketProduct> basketProducts = new ArrayList<>();
    @OneToMany (mappedBy="basket")
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Basket(){}

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }

    public Basket(long basketId, long cost, long totalCost, long qoodsQuantity) {
        this.basketId = basketId;
        this.cost = cost;
        this.totalCost = totalCost;
        this.qoodsQuantity = qoodsQuantity;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketId=" + basketId +
                ", cost=" + cost +
                ", totalCost=" + totalCost +
                ", qoodsQuantity=" + qoodsQuantity +
                '}';
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public long getQoodsQuantity() {
        return qoodsQuantity;
    }

    public void setQoodsQuantity(long qoodsQuantity) {
        this.qoodsQuantity = qoodsQuantity;
    }
}
