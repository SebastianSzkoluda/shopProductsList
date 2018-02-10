package shopProductsList.service;

import shopProductsList.entity.Family;

public interface FamilyService {

	void saveFamily(Family family);
	Family findFamilyByName(String familyName);

}
