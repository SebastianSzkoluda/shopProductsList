package shopProductsList.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopProductsList.entity.Product;
import shopProductsList.repository.ProductRepository;
import shopProductsList.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	ProductServiceImpl(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	@Override
	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}

}
