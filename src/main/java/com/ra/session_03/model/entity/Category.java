package com.ra.session_03.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name="categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="category_name",length = 100,nullable = false,unique = true)
    private String categoryName;
    @Column(name="category_status")
    private Boolean categoryStatus;
    @OneToMany(mappedBy = "category")
//    Cách 2 để lấy category từ product
    @JsonIgnore
    private Set<Product> products;

}
