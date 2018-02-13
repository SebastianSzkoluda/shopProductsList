package shopProductsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import shopProductsList.entity.ShopProduct;
import shopProductsList.service.ShopProductService;

@Controller
public class ShopProductController {

	@Autowired
	 ShopProductService shopProductService;
	
	@RequestMapping(value = "/productsToBuyList", method = RequestMethod.GET)
    public String productsToBuyList(Model model){
		
		
        model.addAttribute("products", shopProductService.currentFamilyProductsToBuy());
        return "productsToBuyList";
    }
	
	@RequestMapping(value = "/{id}/deleteShopProduct", method=RequestMethod.GET)
	public String shopProductDeleteConfirmation(Model model,@PathVariable Integer id) {
		ShopProduct shopProduct = shopProductService.findShopProductById(id);
		model.addAttribute("product", shopProduct);
		return "shopProductDeleteConfirmation";
	}
	
	@RequestMapping(value = "/{id}/deleteShopProduct", method = RequestMethod.POST)
	public String removeProductToBuy(Model model,@PathVariable Integer id) {
		shopProductService.deleteShopProduct(id);
		return "redirect:/productsToBuyList";
	}
}
