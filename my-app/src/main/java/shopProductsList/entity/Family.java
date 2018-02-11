package shopProductsList.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Family {
	
	@Id
	@Column(name = "familyName")
	 String familyName;
	
	@Column(name = "familyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer familyId;	
	
	@Column(name = "numberOfMembers")
	 Integer numberOfMembers;
	
	@Column(name = "averageMonthlyExpenses")
     double averageMonthlyExpenses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familyNameInProduct", orphanRemoval = true, cascade = CascadeType.ALL)
	 List<Product> products;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familyNameInUser", orphanRemoval = true, cascade = CascadeType.ALL)
	 List<FamilyUser> familyUsers;

		
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<FamilyUser> getFamilyUsers() {
		return familyUsers;
	}

	public void setFamilyUsers(List<FamilyUser> familyUsers) {
		this.familyUsers = familyUsers;
	}

	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Integer getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(Integer numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public double getAverageMonthlyExpenses() {
		return averageMonthlyExpenses;
	}

	public void setAverageMonthlyExpenses(double averageMonthlyExpenses) {
		this.averageMonthlyExpenses = averageMonthlyExpenses;
	}
	

}
