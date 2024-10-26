package com.ra.session_03.service.product;

import com.ra.session_03.model.dto.category.CategoryResponseDTO;
import com.ra.session_03.model.dto.product.ProductResponseDTO;
import com.ra.session_03.model.entity.Product;
import com.ra.session_03.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for(Product product:products){
//            cách 1 để lấy category
//            CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO.builder()
//                    .id(product.getCategory().getId())
//                    .categoryName(product.getCategory().getCategoryName())
//                    .categoryStatus(product.getCategory().getCategoryStatus())
//                    .build();
            ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .price(product.getPrice())
                    .image(product.getImage())
//                    .category(categoryResponseDTO)
//                    cách 2
                    .category(product.getCategory())
                    .build();
            productResponseDTOs.add(productResponseDTO);
        }
        return productResponseDTOs;
    }
}
