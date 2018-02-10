package shopProductsList.service;


import shopProductsList.entity.FamilyUser;

public interface FamilyUserService {

	void saveUser(FamilyUser user);
	Iterable<FamilyUser> listAllUsers();	
	FamilyUser findUserByEmail(String email);
	boolean doesLoadUserHaveAFamily();
}
