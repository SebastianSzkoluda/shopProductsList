package shopProductsList.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopProductsList.entity.FamilyUser;
import shopProductsList.repository.FamilyUserRepository;
import shopProductsList.service.FamilyUserService;

@Service
public class FamilyUserServiceImpl implements FamilyUserService {

	
	public FamilyUserRepository familyUserRepository;
	
	@Autowired
	FamilyUserServiceImpl(FamilyUserRepository familyUserRepository){
		this.familyUserRepository = familyUserRepository;
	}
	
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

	

}
