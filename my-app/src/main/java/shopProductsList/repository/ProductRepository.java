package shopProductsList.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import shopProductsList.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.shop LIKE :shop ")
	Product findByShop(@Param("shop") String shop);
}
