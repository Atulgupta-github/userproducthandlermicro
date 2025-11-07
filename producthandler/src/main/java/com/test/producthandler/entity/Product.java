package com.test.producthandler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_desc") // ✅ renamed from 'desc' (reserved)
    private String productDesc;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // ✅ consistent with users.userid
    private User user;
}
