package com.ra.session_03.service.category;

import com.ra.session_03.model.dto.category.CategoryRequestDTO;
import com.ra.session_03.model.dto.category.CategoryResponseDTO;
import com.ra.session_03.model.dto.category.CategoryUpdateRequestDTO;
import com.ra.session_03.model.entity.Category;
import com.ra.session_03.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
//        Convert Entity và DTO
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
        for (Category category : categories) {
            CategoryResponseDTO categoryItem = CategoryResponseDTO.builder()
                    .id(category.getId())
                    .categoryName(category.getCategoryName())
                    .categoryStatus(category.getCategoryStatus())
                    .build();
            categoryResponseDTOS.add(categoryItem);
            
        }
        return categoryResponseDTOS;
    }

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO) {
        Category category = Category.builder()
                .categoryName(categoryRequestDTO.getCategoryName())
                .categoryStatus(categoryRequestDTO.isCategoryStatus())
                .build();
        Category categoryNew = categoryRepository.save(category);
        return CategoryResponseDTO.builder()
                .id(categoryNew.getId())
                .categoryName(categoryNew.getCategoryName())
                .categoryStatus(categoryNew.getCategoryStatus())
                .build();
    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);

        assert category != null;
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .categoryStatus(category.getCategoryStatus())
                .build();
    }

    @Override
    public CategoryResponseDTO update(CategoryUpdateRequestDTO categoryUpdateRequestDTO) {
        Category category = Category.builder()
                .id(categoryUpdateRequestDTO.getId())
                .categoryName(categoryUpdateRequestDTO.getCategoryName())
                .categoryStatus(categoryUpdateRequestDTO.isCategoryStatus())
                .build();
        Category categoryUpdated = categoryRepository.save(category);

        return CategoryResponseDTO.builder()
                .id(categoryUpdated.getId())
                .categoryName(categoryUpdated.getCategoryName())
                .categoryStatus(categoryUpdated.getCategoryStatus())
                .build();
    }


    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<CategoryResponseDTO> paginate(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        Page<CategoryResponseDTO> categoryResponseDTOS= categories
                .map(category -> {
                    CategoryResponseDTO responseDTO = new CategoryResponseDTO();
                    responseDTO.setId(category.getId());
                    responseDTO.setCategoryName(category.getCategoryName());
                    responseDTO.setCategoryStatus(category.getCategoryStatus());
                    return responseDTO;
                });
        return categoryResponseDTOS;
    }
}
