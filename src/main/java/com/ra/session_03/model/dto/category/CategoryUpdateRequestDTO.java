package com.ra.session_03.model.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryUpdateRequestDTO {
    private Long id;
    private String categoryName;
    private boolean categoryStatus;
}
