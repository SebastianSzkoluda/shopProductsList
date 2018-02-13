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
import shopProductsList.entity.ShopProduct;
import shopProductsList.repository.FamilyRepository;
import shopProductsList.repository.FamilyUserRepository;
import shopProductsList.repository.ProductRepository;
import shopProductsList.repository.ShopProductRepository;
import shopProductsList.service.ShopProductService;

@Service
public class ShopProductServiceImpl implements ShopProductService {

	@Autowired
	private ShopProductRepository shopProductRepository;
	
	@Autowired
	private FamilyUserRepository familyUserRepository;
	
	@Autowired
	private FamilyRepository familyRepository;
	
	@Override
	public void saveShopProduct(ShopProduct shopProduct) {
		shopProductRepository.save(shopProduct);
		
	}

	@Override
	public ShopProduct findShopProductById(Integer id) {
		
		return shopProductRepository.findById(id);
	}

	@Override
	public void deleteShopProduct(Integer id) {
		shopProductRepository.delete(id);
		
	}

	@Override
	public List<ShopProduct> currentFamilyProductsToBuy() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		FamilyUser familyUser = familyUserRepository.findByEmail(auth.getName());
		Family family = familyRepository.findByName(familyUser.getFamilyNameInUser());
		return family.getProductsToBuy();
	}
	@Transactional
	@Override
	public void addingProductToFamilyProductListToBuy(ShopProduct shopProduct) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		FamilyUser familyUser = familyUserRepository.findByEmail(auth.getName());
		Family family = familyRepository.findByName(familyUser.getFamilyNameInUser());
		
		shopProduct.setFamilyNameInShopProduct(familyUser.getFamilyNameInUser());
		family.getProductsToBuy().add(shopProduct);
	}

}
