package com.example.springbootdemo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "shop")
@Component
public class Shop {

    @Id
    @Column(name = "id_shop")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShop;

    @Column(name = "name_shop")
    @NotBlank
    private String nameShop;

    @Column(name = "address_shop")
    @NotBlank
    private String addressShop;

    @Column(name = "privilege")
    @Min(value = 1,message = "must not be blank")
    private double privilege;

    public Shop() {
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getAddressShop() {
        return addressShop;
    }

    public void setAddressShop(String addressShop) {
        this.addressShop = addressShop;
    }

    public double getPrivilege() {
        return privilege;
    }

    public void setPrivilege(double privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "idShop=" + idShop +
                ", nameShop='" + nameShop + '\'' +
                ", addressShop='" + addressShop + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
