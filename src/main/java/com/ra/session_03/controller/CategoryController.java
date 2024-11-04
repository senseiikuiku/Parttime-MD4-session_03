package com.ra.session_03.controller;

import com.ra.session_03.model.dto.category.CategoryRequestDTO;
import com.ra.session_03.model.dto.category.CategoryResponseDTO;
import com.ra.session_03.model.dto.category.CategoryUpdateRequestDTO;
import com.ra.session_03.model.dto.product.ProductResponseDTO;
import com.ra.session_03.service.category.CategoryService;
import com.ra.session_03.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping
//    public ResponseEntity<List<CategoryResponseDTO>> index() {
//        List<CategoryResponseDTO> responseDTOS = categoryService.findAll();
//        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
//    }

//    Danh sách có phân trang
    @GetMapping
    public ResponseEntity<?> index(@RequestParam(defaultValue = "0",name="page")int page,
                                   @RequestParam(defaultValue = "3",name = "limit") int limit,
                                   @RequestParam(defaultValue = "ASC",name = "order") String sort,
                                   @RequestParam(defaultValue = "id",name = "sortBy") String sortBy){

        Pageable pageable;
        if(sort.equalsIgnoreCase("asc")){
            pageable = PageRequest.of(page, limit, Sort.by(sortBy).ascending());
        }else {
            pageable = PageRequest.of(page, limit, Sort.by(sortBy).descending());
        }
        Page<CategoryResponseDTO> categoryResponseDTOS = categoryService.paginate(pageable);
        return new ResponseEntity<>(categoryResponseDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        CategoryResponseDTO responseDTO = categoryService.create(categoryRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id) {
        CategoryResponseDTO responseDTO = categoryService.findById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id,
                                                      @RequestBody CategoryUpdateRequestDTO categoryUpdateRequestDTO) {
        categoryUpdateRequestDTO.setId(id);
        CategoryResponseDTO responseDTO = categoryService.update(categoryUpdateRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
