package shopProductsList.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import shopProductsList.entity.FamilyUser;
import shopProductsList.repository.FamilyUserRepository;
import shopProductsList.repository.FamilyUserRepositoryCustom;

public class FamilyUserRepositoryImpl implements FamilyUserRepositoryCustom {
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	FamilyUserRepository familyUserRepository;
	
	@Override
	public FamilyUser findByEmail(String email) {
		List<FamilyUser> resultList = em.createQuery(
		        "SELECT f FROM FamilyUser f WHERE f.email LIKE :email", FamilyUser.class)
		        .setParameter("email", email)
		        .getResultList();
		
		return resultList.isEmpty() ? null : resultList.get(0);
	}

}
