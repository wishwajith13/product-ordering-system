package com.product.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;

    @CreatedBy
    @Column(updatable = false)
    private Integer createdBy;
    @CreatedDate
    @Column(updatable = false)
    private Date createdDate;
    @LastModifiedBy
    @Column(insertable = false)
    private Integer updatedBy;
    @LastModifiedDate
    @Column(insertable = false)
    private Date updateDate;
}
