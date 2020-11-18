package com.example.springbootdemo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "product")
@Component
public class Product {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(name = "name_product")
    @NotBlank
    private String nameProduct;

    @Column(name = "price")
    @Min(value = 1,message = "must not be blank")
    private double price;

    @Column(name = "address_stock")
    @NotBlank
    private String addressStock;

    @Column(name = "max_amount")
    @Min(value = 1,message = "must not be blank")
    private int maxAmount;

    @Column(name = "lastdateorder")
    @NotBlank
    private String lastDate;

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddressStock() {
        return addressStock;
    }

    public void setAddressStock(String addressStock) {
        this.addressStock = addressStock;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }


    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", addressStock='" + addressStock + '\'' +
                ", maxAmount=" + maxAmount +
                ", lastDate='" + lastDate + '\'' +
                '}';
    }
}
