package shopProductsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopProductsList.entity.ShopProduct;
import shopProductsList.service.ShopProductService;

@Controller
public class AddShopProductController {

	@Autowired
	ShopProductService shopProductService;
	
	@RequestMapping(value = "/addProductToBuy", method = RequestMethod.GET)
	String addProductPage(ModelAndView modelAndView, ShopProduct shopProduct) {
		
		modelAndView.addObject("shopProduct",shopProduct);
		return "addProductToBuy";
		
	}
	
	@RequestMapping(value = "/dodajProduktDoListyZakupów", method = RequestMethod.POST)
	String addingProduct(@ModelAttribute("shopProduct") ShopProduct shopProduct) {
	
		shopProductService.saveShopProduct(shopProduct);
		shopProductService.addingProductToFamilyProductListToBuy(shopProduct);
		
		return "productsToBuyList";
				
	}
}
