package shopProductsList.service;


import java.util.List;

import shopProductsList.entity.FamilyUser;
import shopProductsList.entity.Product;

public interface FamilyUserService {

	void saveUser(FamilyUser user);
	Iterable<FamilyUser> listAllUsers();	
	FamilyUser findUserByEmail(String email);
	boolean doesLoadUserHaveAFamily();
	
}
