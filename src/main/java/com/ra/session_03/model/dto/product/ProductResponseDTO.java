package com.ra.session_03.model.dto.product;

import com.ra.session_03.model.dto.category.CategoryResponseDTO;
import com.ra.session_03.model.entity.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductResponseDTO {
    private Long id;
    private String productName;
    private double price;
    private String image;
//    cách 1 để lấy category
//    private CategoryResponseDTO category;
    private Category category;// Cách 2
}
