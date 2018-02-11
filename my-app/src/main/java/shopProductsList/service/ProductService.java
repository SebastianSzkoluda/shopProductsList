package shopProductsList.service;

import java.util.List;

import shopProductsList.entity.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();
	void saveProduct(Product product);
	Product findProductById(Integer id);
	void deleteProduct(Integer id);
	List<Product> currentFamilyProducts();
	void addingProductToFamilyProductList(Product product);
}
