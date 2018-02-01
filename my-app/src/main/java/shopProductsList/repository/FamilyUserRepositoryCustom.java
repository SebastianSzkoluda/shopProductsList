package shopProductsList.repository;

import shopProductsList.entity.FamilyUser;

public interface FamilyUserRepositoryCustom {

	FamilyUser findByEmail(String email);
}
