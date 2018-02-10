package shopProductsList.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopProductsList.entity.Family;
import shopProductsList.repository.FamilyRepository;
import shopProductsList.service.FamilyService;

@Service
public class FamilyServiceImpl implements FamilyService {

	private FamilyRepository familyRepository;
	
	@Autowired
	public FamilyServiceImpl(FamilyRepository familyRepository) {
		this.familyRepository = familyRepository;
	}
	
	@Override
	public void saveFamily(Family family) {
		familyRepository.save(family);
		
	}

	@Override
	public Family findFamilyByName(String familyName) {
	
		return familyRepository.findByName(familyName);
	}
	
}
