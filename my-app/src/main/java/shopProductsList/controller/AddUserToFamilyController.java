package shopProductsList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopProductsList.entity.FamilyUser;


@Controller
public class AddUserToFamilyController {

	@RequestMapping(value = "/addUserToFamily", method = RequestMethod.GET)
	String addProductPage(ModelAndView modelAndView, FamilyUser familyUser) {
		
		modelAndView.addObject("familyUser",familyUser);
		return "addUserToFamily";
		
	}
	
	
}
