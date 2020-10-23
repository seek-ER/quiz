package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPO {
    private String name;
    private int price;
    private int number;
    private String unit;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
