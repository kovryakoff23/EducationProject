package com.Magazine.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "user_id")
   private long userId;
    @Column(name = "name")
   private String name;
    @Column(name = "surname")
   private String surname;
    @Column(name = "phone_number")
   private long phoneNumber;
    @Column(name = "email")
   private String email;
    @Column(name = "birthdate")
   private Date birthdate;
    @Column(name = "rating")
   private long rating;
    @Column(name = "orders_quantity")
   private long ordersQuantity;
    @ManyToOne (optional=false, cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
    @JoinColumn (name="order_id")
    private OrderHistory order;
    @ManyToOne (optional=false, cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
    @JoinColumn (name="address_id")
    private Address address;
    @ManyToOne (optional=false, cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
    @JoinColumn (name="basket_id")
    private Basket basket;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Discount> discounts =new ArrayList<>();
    public User(){}

    public User(long userId, OrderHistory order, Address address, Basket basket) {
        this.userId = userId;
        this.order = order;
        this.address = address;
        this.basket = basket;
    }

    public User(long userId, String name, String surname, long phoneNumber, Date birthdate,
                long rating, long ordersQuantity, OrderHistory order, Address address, Basket basket,
                List<Discount> discounts) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.rating = rating;
        this.ordersQuantity = ordersQuantity;
        this.order = order;
        this.address = address;
        this.basket = basket;
        this.discounts = discounts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getOrdersQuantity() {
        return ordersQuantity;
    }

    public void setOrdersQuantity(long ordersQuantity) {
        this.ordersQuantity = ordersQuantity;
    }

    public OrderHistory getOrder() {
        return order;
    }

    public void setOrder(OrderHistory order) {
        this.order = order;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
