package shopProductsList.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer id;
	
	@Column(name = "name")
	 String productName;
	
	@Column(name = "shop")
	 String shop;
	
	@Column(name = "frequencyOfUse")
	 Integer frequencyOfUse;
	
	@Column(name = "averageCost")
	 double averageCost;

	@Column(name ="amount")
	 double amount;
	
	@Column(name = "amountPerDay")
	 double amountPerDay;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public Integer getFrequencyOfUse() {
		return frequencyOfUse;
	}

	public void setFrequencyOfUse(Integer frequencyOfUse) {
		this.frequencyOfUse = frequencyOfUse;
	}

	public double getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(double averageCost) {
		this.averageCost = averageCost;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmountPerDay() {
		return amountPerDay;
	}

	public void setAmountPerDay(double amountPerDay) {
		this.amountPerDay = amountPerDay;
	}
	
	
	
	
}
