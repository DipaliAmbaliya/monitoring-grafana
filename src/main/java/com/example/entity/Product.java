package com.example.entity;

//import org.hibernate.envers.Audited;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Audited
@Entity
@Table(name = "product_detail")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", length = 10, nullable = false)
    private int id;
    @Column(name = "product_name", length = 45, nullable = true)
    private String pname;

    @NotAudited
    @Column(name = "batch_number", length = 45, nullable = true)
    private String batchno;
    @Column(name = "price", length = 45, nullable = true)
    private double price;

    //default constructor
    public Product() {

    }

    //constructor using fields
    public Product(int id, String pname, String batchno, double price) {
        super();
        this.id = id;
        this.pname = pname;
        this.batchno = batchno;
        this.price = price;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}