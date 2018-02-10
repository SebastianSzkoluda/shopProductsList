package shopProductsList.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import shopProductsList.entity.FamilyUser;
import shopProductsList.repository.FamilyUserRepository;
import shopProductsList.service.FamilyUserService;

@Service
public class FamilyUserServiceImpl implements FamilyUserService {

	@Autowired
	FamilyUserRepository familyUserRepository;
	
	

	@Override
	public void saveUser(FamilyUser user) {
		
		familyUserRepository.save(user);
	}

	@Override
	public Iterable<FamilyUser> listAllUsers() {
		// TODO Auto-generated method stub
		return familyUserRepository.findAll();
	}

	@Override
	public FamilyUser findUserByEmail(String email) {
		
		return familyUserRepository.findByEmail(email);
	}

	@Override
	public boolean doesLoadUserHaveAFamily() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		FamilyUser familyUser = familyUserRepository.findByEmail(auth.getName());
		if(familyUser.getFamilyNameInUser() == null) {
			return true;
		}
		else {
			return false;
		}
		
	}

	

}
