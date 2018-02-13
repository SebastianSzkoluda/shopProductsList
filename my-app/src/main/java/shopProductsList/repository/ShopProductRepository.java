package shopProductsList.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import shopProductsList.entity.ShopProduct;

public interface ShopProductRepository extends CrudRepository<ShopProduct, Integer> {

	@Query("SELECT sp FROM ShopProduct sp WHERE sp.shop LIKE :shop ")
	ShopProduct findByShop(@Param("shop") String shop);
	
	@Query("SELECT sp FROM ShopProduct sp WHERE sp.id LIKE :id ")
	ShopProduct findById(@Param("id") Integer id);
}
