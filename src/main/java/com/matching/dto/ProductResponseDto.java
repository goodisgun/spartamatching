package com.matching.dto;

import com.matching.entity.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponseDto {


    private final Long productId;

    private final String productName;

    private final String information;

    private final Long SellerId;

    private final LocalDateTime createAt;


    public ProductResponseDto(Long productId, String productName, String information, Long sellerId, LocalDateTime createAt) {
        this.productId = productId;
        this.productName = productName;
        this.information = information;
        SellerId = sellerId;
        this.createAt = createAt;
    }
}
