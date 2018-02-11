package shopProductsList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import shopProductsList.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.shop LIKE :shop ")
	Product findByShop(@Param("shop") String shop);
	
	@Query("SELECT p FROM Product p WHERE p.id LIKE :id ")
	Product findById(@Param("id") Integer id);
	
	@Query("SELECT p FROM Product p WHERE p.familyNameInProduct = ?1")
	List<Product> listCurrentFamilyProducts(String familyName);
}
