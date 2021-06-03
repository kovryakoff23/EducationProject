package com.Magazine.entity;

import javax.persistence.*;

@Entity
@Table(name = "BasketProduct")
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bpId;
    @ManyToOne (optional=false, cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
    @JoinColumn (name="basket_id")
    private Basket basket;
    @ManyToOne (optional=false, cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
    @JoinColumn (name="article")
    private Product product;
    @Column(name = "quantity")
    private long quantity;

    public BasketProduct(){}

    public BasketProduct(Basket basket, Product product) {
        this.basket = basket;
        this.product = product;
    }

    public BasketProduct(Basket basket, Product product, long quantity) {
        this.basket = basket;
        this.product = product;
        this.quantity = quantity;
    }

    public long getBpId() {
        return bpId;
    }

    public void setBpId(long bpId) {
        this.bpId = bpId;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
