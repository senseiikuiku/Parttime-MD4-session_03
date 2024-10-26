package com.ra.session_03.model.dto.product;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductRequestDTO {
    private String productName;
    private double price;
    private String image;
    private Long categoryId;
}
