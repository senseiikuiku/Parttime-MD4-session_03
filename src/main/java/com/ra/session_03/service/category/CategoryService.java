package com.ra.session_03.service.category;

import com.ra.session_03.model.dto.category.CategoryRequestDTO;
import com.ra.session_03.model.dto.category.CategoryResponseDTO;
import com.ra.session_03.model.dto.category.CategoryUpdateRequestDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO findById(Long id);
    CategoryResponseDTO update(CategoryUpdateRequestDTO categoryUpdateRequestDTO);
    void delete(Long id);

}
