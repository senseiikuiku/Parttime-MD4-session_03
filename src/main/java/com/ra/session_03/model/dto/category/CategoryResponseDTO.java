package com.ra.session_03.model.dto.category;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CategoryResponseDTO {
    private Long id;
    private String categoryName;
    private boolean categoryStatus;
}
