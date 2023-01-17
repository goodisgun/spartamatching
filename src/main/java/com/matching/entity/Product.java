package com.matching.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String productName;

    @Column
    private String information;

    @Column
    private long sellerId;

    @Column
    private int point;

    @Column
    private boolean activation;

}
