package shopProductsList.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;


import shopProductsList.service.FamilyUserService;
import shopProductsList.service.ProductService;
import shopProductsList.service.impl.FamilyUserServiceImpl;
import shopProductsList.service.impl.ProductServiceImpl;

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
	
	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}
}
