package ru.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mvc.models.Product;

import java.util.List;

/**
 * 20.12.2020
 * ProductsRepository
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBySeller_LoginOrderByPriceDesc(String login);
    Product findProductById(long id);
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByProduct(String product);
    List<Product> findAllByProductOrderByPrice(String product);

    @Query("select product.id from #{#entityName} product")
    List<Long> findAllId();
}