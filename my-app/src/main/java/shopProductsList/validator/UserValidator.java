package shopProductsList.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import shopProductsList.entity.FamilyUser;
import shopProductsList.service.FamilyUserService;

@Component
public class UserValidator implements Validator {
	@Autowired
    private FamilyUserService familyUserService;
	
	 @Override
	    public boolean supports(Class<?> aClass) {
	        return FamilyUser.class.equals(aClass);
	    }
	 @Override
	    public void validate(Object o, Errors errors) {
	        FamilyUser user =  (FamilyUser) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
	        if (user.getEmail().length() < 6 || user.getEmail().length() > 56) {
	            errors.rejectValue("email", "Size.familyUser.email");
	        }
	        if (familyUserService.findUserByEmail(user.getEmail()) != null) {
	            errors.rejectValue("familyUser", "Duplicate.familyUser.email");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
	            errors.rejectValue("password", "Size.familyUser.password");
	        }

	        if (!user.getPasswordConfirm().equals(user.getPassword())) {
	            errors.rejectValue("passwordConfirm", "Diff.familyUser.passwordConfirm");
	        }
	    }
}
