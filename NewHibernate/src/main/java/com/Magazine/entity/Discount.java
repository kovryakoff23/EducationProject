package com.Magazine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Discount")
public class Discount {
    @Id
    @Column(name = "user_id")
    private long userId;
    @Column(name = "user_discount")
    private long userDiscount;
    @Column(name = "coupons")
    private long coupons;
    @Column(name = "total_discount")
    private long totalDiscount;
public Discount(){}
    public Discount(long userId, long userDiscount, long coupons, long totalDiscount) {
        this.userId = userId;
        this.userDiscount = userDiscount;
        this.coupons = coupons;
        this.totalDiscount = totalDiscount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
