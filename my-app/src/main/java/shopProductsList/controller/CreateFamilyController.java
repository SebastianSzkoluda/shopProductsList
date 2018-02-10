package shopProductsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopProductsList.entity.Family;
import shopProductsList.entity.FamilyUser;
import shopProductsList.repository.FamilyUserRepository;
import shopProductsList.service.FamilyService;


@Controller
public class CreateFamilyController {

	@Autowired
	FamilyService familyService;
	
	@Autowired
	FamilyUserRepository familyUserRepository;
	
	@RequestMapping(value = "/createFamily", method = RequestMethod.GET)
	String addProductPage(ModelAndView modelAndView, Family family) {
		
		modelAndView.addObject("family",family);
		return "createFamily";
		
	}
	
	@RequestMapping(value = "/dodajRodzinke", method = RequestMethod.POST)
	String addingProduct(@ModelAttribute("family") Family family) {
		familyService.saveFamily(family);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		FamilyUser familyUser = familyUserRepository.findByEmail(auth.getName());
		
		
		familyUser.setFamilyNameInUser(family.getFamilyName());
				
		return "index";
				
	}
}
