package shopProductsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopProductsList.entity.Product;
import shopProductsList.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	

	@RequestMapping(value = "/productsList", method = RequestMethod.GET)
    public String productList(Model model){
		
		
        model.addAttribute("products", productService.currentFamilyProducts());
        return "productsList";
    }
	
	@RequestMapping(value = "/{id}/delete", method=RequestMethod.GET)
	public String productDeleteConfirmation(Model model,@PathVariable Integer id) {
		Product product = productService.findProductById(id);
		model.addAttribute("product", product);
		return "productDeleteConfirmation";
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String removeProduct(Model model,@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "redirect:/productsList";
	}
}


