package shopProductsList.service;

import java.util.List;

import shopProductsList.entity.ShopProduct;

public interface ShopProductService {

	void saveShopProduct(ShopProduct shopProduct);
	ShopProduct findShopProductById(Integer id);
	void deleteShopProduct(Integer id);
	List<ShopProduct> currentFamilyProductsToBuy();
	void addingProductToFamilyProductListToBuy(ShopProduct shopProduct);
}
