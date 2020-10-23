package com.twuc.shopping.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "allOrder")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllOrderPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "allOrderOnce", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(min = 1)
    List<OrderPO> orders;
}
