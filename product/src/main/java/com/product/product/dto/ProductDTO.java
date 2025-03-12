package com.product.product.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;

    private Integer createdBy;
    private Date createdDate;
    private Integer updatedBy;
    private Date updateDate;
}
