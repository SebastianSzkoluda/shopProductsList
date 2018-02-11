package shopProductsList.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import shopProductsList.entity.Family;
import shopProductsList.entity.FamilyUser;
import shopProductsList.entity.Product;
import shopProductsList.repository.FamilyRepository;
import shopProductsList.repository.FamilyUserRepository;
import shopProductsList.repository.ProductRepository;
import shopProductsList.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private FamilyUserRepository familyUserRepository;
	
	@Autowired
	private FamilyRepository familyRepository;
	
	@Override
	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}
	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
		
	}
	@Override
	public Product findProductById(Integer id) {
		
		return productRepository.findById(id);
	}
	@Override
	public void deleteProduct(Integer id) {
		productRepository.delete(id);
		
	}
	
	
	
	@Transactional
	@Override
	public List<Product> currentFamilyProducts() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		FamilyUser familyUser = familyUserRepository.findByEmail(auth.getName());
		Family family = familyRepository.findByName(familyUser.getFamilyNameInUser());
	
		return family.getProducts();
	}
	
	@Transactional
	@Override
	public void addingProductToFamilyProductList(Product product) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		FamilyUser familyUser = familyUserRepository.findByEmail(auth.getName());
		Family family = familyRepository.findByName(familyUser.getFamilyNameInUser());
		family.getProducts().add(product);
		product.setFamilyNameInProduct(familyUser.getFamilyNameInUser());
		
	}
	@Override
	public List<Product> listAllProductsOfFamily() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		FamilyUser familyUser = familyUserRepository.findByEmail(auth.getName());
		Family family = familyRepository.findByName(familyUser.getFamilyNameInUser());
		return productRepository.listCurrentFamilyProducts(family.getFamilyName());
	}
	

}
