package shopProductsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopProductsList.entity.FamilyUser;
import shopProductsList.service.FamilyUserService;
import shopProductsList.validator.UserValidator;

@Controller
public class RegisterController {

	@Autowired
	Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	FamilyUserService familyUserService;
	
	@Autowired
	UserValidator userValidator;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	String registerPage(ModelAndView modelAndView, FamilyUser familyUser) {
		
		modelAndView.addObject("familyUser",familyUser);
		return "register";
		
	}
	
	@RequestMapping(value = "/dodajUsera", method = RequestMethod.POST)
	String registeration(@ModelAttribute("familyUser") FamilyUser familyUser,BindingResult bindingResult) {
		userValidator.validate(familyUser, bindingResult);
		String md5Password = familyUser.getPassword();
		String hashedPassword = md5PasswordEncoder.encodePassword(md5Password, null);
		familyUser.setPassword(hashedPassword);
		String md5Password1 = familyUser.getPasswordConfirm();
		String hashedPassword1 = md5PasswordEncoder.encodePassword(md5Password1, null);
		familyUser.setPasswordConfirm(hashedPassword1);
		familyUserService.saveUser(familyUser);
		
		return "index";
				
	}
	
	
	
}
