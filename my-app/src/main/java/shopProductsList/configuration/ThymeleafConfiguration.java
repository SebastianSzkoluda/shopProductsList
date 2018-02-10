package shopProductsList.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import shopProductsList.repository.FamilyUserRepository;
import shopProductsList.service.FamilyUserService;
import shopProductsList.service.impl.FamilyUserServiceImpl;

@Configuration
public class ThymeleafConfiguration {

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
	    return new SpringSecurityDialect();
	}

	@Bean
	public FamilyUserService familyUserService() {
		return new FamilyUserServiceImpl();
	}
}
