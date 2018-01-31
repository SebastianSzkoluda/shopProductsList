package shopProductsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import shopProductsList.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	

	@RequestMapping(value = "/productsList", method = RequestMethod.GET)
    public String clientList(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "productsList";
    }
}


