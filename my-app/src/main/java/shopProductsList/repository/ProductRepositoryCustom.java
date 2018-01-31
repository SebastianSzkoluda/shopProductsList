package shopProductsList.repository;

import shopProductsList.entity.Product;

public interface ProductRepositoryCustom {

	Product searchProductByShop(String shop);
}
