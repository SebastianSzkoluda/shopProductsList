package shopProductsList.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopproduct")
public class ShopProduct {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer id;
	
	@Column(name = "productName")
	 String shopProductName;
	
	@Column(name = "shop")
	 String shop;
	
	@Column(name = "prize")
	 double prize;
	
	@Column(name = "weightOfOneProduct")
	 double weightOfOneProduct;
	
	@Column(name = "productQuantity")
	 Integer productQuantity;
	
	@Column(name = "f_familyName")
	 String familyNameInShopProduct;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopProductName() {
		return shopProductName;
	}

	public void setShopProductName(String shopProductName) {
		this.shopProductName = shopProductName;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public double getWeightOfOneProduct() {
		return weightOfOneProduct;
	}

	public void setWeightOfOneProduct(double weightOfOneProduct) {
		this.weightOfOneProduct = weightOfOneProduct;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getFamilyNameInShopProduct() {
		return familyNameInShopProduct;
	}

	public void setFamilyNameInShopProduct(String familyNameInShopProduct) {
		this.familyNameInShopProduct = familyNameInShopProduct;
	}
	
	
}
