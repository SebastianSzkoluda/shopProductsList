package shopProductsList.repository;

import org.springframework.data.repository.CrudRepository;

import shopProductsList.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>, ProductRepositoryCustom {

}
