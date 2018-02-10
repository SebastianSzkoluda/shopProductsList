package shopProductsList.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Family {
	
	@Id
	@Column(name = "familyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer familyId;
	
	@Column(name = "familyName")
	 String familyName;
	
	
	@Column(name = "numberOfMembers")
	 Integer numberOfMembers;
	
	@Column(name = "averageMonthlyExpenses")
     double averageMonthlyExpenses;

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
