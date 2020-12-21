package ru.mvc.models;

import lombok.*;
import javax.persistence.*;

/**
 * 20.12.2020
 * Product
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "seller")
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private String description;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "seller")
    private User seller;
}
