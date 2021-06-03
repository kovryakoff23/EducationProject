package com.Magazine.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "article")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long article;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private long price;
    @Column(name = "vendor")
    private long vendor;
    @Column(name = "discount")
    private long discount;
    @Column(name = "avability")
    private boolean avability;
    @Column(name = "quantity")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(long article, String name, String description, long price, long vendor, long discount, boolean avability, int quantity) {
        this.article = article;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vendor = vendor;
        this.discount = discount;
        this.avability = avability;
        this.quantity = quantity;
    }

    public Product(){}

    @Override
    public String toString() {
        return "Product{" +
                "article=" + article +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vendor=" + vendor +
                ", discount=" + discount +
                ", availability=" + avability +
                '}';
    }
    public Product(long article, String name, String description, long price, long vendor, long discount, boolean avability) {
        this.article = article;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vendor = vendor;
        this.discount = discount;
        this.avability = avability;
    }

    public void setArticle(long article) {
        this.article = article;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setVendor(long vendor) {
        this.vendor = vendor;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public void setAvability(boolean avability) {
        this.avability = avability;
    }

    public long getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }

    public long getVendor() {
        return vendor;
    }

    public long getDiscount() {
        return discount;
    }

    public boolean isAvability() {
        return avability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                vendor == product.vendor && discount == product.discount &&
                avability == product.avability &&
                name.equals(product.name) && description.equals(product.description);
    }

}
