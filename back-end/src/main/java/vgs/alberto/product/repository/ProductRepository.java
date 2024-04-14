package vgs.alberto.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vgs.alberto.product.entity.Product;

@Repository
public class ProductRepository extends CrudRepository<Product, Long> {
}
