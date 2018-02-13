package shopProductsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopProductsList.entity.FamilyUser;
import shopProductsList.entity.Product;
import shopProductsList.repository.FamilyUserRepository;
import shopProductsList.service.FamilyUserService;


@Controller
public class AddUserToFamilyController {

	@Autowired
	FamilyUserService familyUserService;
	
	@Autowired
	FamilyUserRepository familyUserRepository;
	
	@RequestMapping(value = "/addUserToFamily", method = RequestMethod.GET)
	String addProductPage(ModelAndView modelAndView, FamilyUser familyUser) {
		
		modelAndView.addObject("familyUser",familyUser);
		return "addUserToFamily";		
	}
	
	@RequestMapping(value = "/dodajCzlonkaRodzinki", method = RequestMethod.POST)
	String addingProduct(@ModelAttribute("familyUser") FamilyUser familyUser) {

	FamilyUser addingFamilyUser = familyUserRepository.findByEmail(familyUser.getEmail());
		familyUserService.addingUserToFamily(addingFamilyUser);
		familyUserService.saveUser(addingFamilyUser);
		
		return "index";
				
	}
	
	
}
