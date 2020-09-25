package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPO {
    private String name;
    private int price;
    private String unit;
    private String picture;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
