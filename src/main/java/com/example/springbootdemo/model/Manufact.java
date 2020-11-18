package com.example.springbootdemo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table(name = "manufacturer")
@Component
public class Manufact {

    @Id
    @Column(name = "id_manufact")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idManufact;

    @Column(name = "name_manufact")
    @NotBlank
    private String nameManufact;

    @Column(name = "address_manufact")
    @NotBlank
    private String addressManufact;

    @Column(name = "pay_for_service")
    private float pay;

  /*  public Manufact() {
    }

    public int getIdManufact() {
        return idManufact;
    }

    public void setIdManufact(int idManufact) {
        this.idManufact = idManufact;
    }

    public String getNameManufact() {
        return nameManufact;
    }

    public void setNameManufact(String nameManufact) {
        this.nameManufact = nameManufact;
    }

    public String getAddressManufact() {
        return addressManufact;
    }

    public void setAddressManufact(String addressManufact) {
        this.addressManufact = addressManufact;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "idManufact=" + idManufact +
                ", nameManufact='" + nameManufact + '\'' +
                ", addressManufact='" + addressManufact + '\'' +
                ", pay=" + pay +
                '}';
    }*/


}
