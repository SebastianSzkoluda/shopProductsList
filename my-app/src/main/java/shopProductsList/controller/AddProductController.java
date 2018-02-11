package shopProductsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shopProductsList.entity.Product;
import shopProductsList.service.ProductService;

@Controller
public class AddProductController {

	@Autowired 
	ProductService productService;
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	String addProductPage(ModelAndView modelAndView, Product product) {
		
		modelAndView.addObject("product",product);
		return "addProduct";
		
	}
	
	@RequestMapping(value = "/dodajProdukt", method = RequestMethod.POST)
	String addingProduct(@ModelAttribute("product") Product product) {
	
		productService.saveProduct(product);
		productService.addingProductToFamilyProductList(product);
		
		return "productsList";
				
	}

}
