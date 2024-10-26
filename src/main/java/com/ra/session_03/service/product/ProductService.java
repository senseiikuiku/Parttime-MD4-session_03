package com.ra.session_03.service.product;

import com.ra.session_03.model.dto.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> findAll();
}
