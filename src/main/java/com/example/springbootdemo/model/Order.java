package com.example.springbootdemo.model;


import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name = "orders")
@Component
public class Order {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;


    @Column(name = "date_of_order")
    @NotBlank
    private String dateOrder;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "atelie",nullable = false)
    private Manufact manufact;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "shop",nullable = false)
    private Shop shop;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product",nullable = false)
    private Product product;

    @Column(name = "amount")
    @Min(value = 1,message = "must not be blank")
    private int amount;

    @Column(name = "cost")
    @Min(value = 1,message = "must not be blank")
    private double cost;

    @Column(name = "commis")
    private int commis;

    public Order() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Manufact getManufact() {
        return manufact;
    }

    public void setManufact(Manufact manufact) {
        this.manufact = manufact;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCommis() {
        return commis;
    }

    public void setCommis(int commis) {
        this.commis = commis;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", dateOrder=" + dateOrder +
                ", manufact=" + manufact +
                ", shop=" + shop +
                ", product=" + product +
                ", amount=" + amount +
                ", cost=" + cost +
                ", commis=" + commis +
                '}';
    }
}
