package shopProductsList.service;

import shopProductsList.entity.Product;

public interface ProductService {

	Iterable<Product> listAllProducts();
	void saveProduct(Product product);
}
