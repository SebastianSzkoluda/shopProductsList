package shopProductsList.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import shopProductsList.entity.Product;
import shopProductsList.repository.ProductRepository;
import shopProductsList.repository.ProductRepositoryCustom;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product searchProductByShop(String shop) {
		List<Product> resultList = em.createQuery(
		        "SELECT p FROM Product p WHERE p.shop LIKE :productShop", Product.class)
		        .setParameter("productShop", shop)
		        .getResultList();
		
		return resultList.isEmpty() ? null : resultList.get(0);
	}

}
