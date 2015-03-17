package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.muthaka.dairy.Models.MilkSold;
import org.muthaka.dairy.service.MilkSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * Created by MUTHAKA on 3/10/2015.
 */
@Controller public class MilkSoldController {

	private static final Logger logger = Logger.getLogger(MilkSoldController.class);
	private MilkSoldService milkSoldService;

	@Autowired(required = true) @Qualifier(value = "milkSoldService")
	public void setMealService(MilkSoldService milkSoldService1) {
		this.milkSoldService = milkSoldService1;
	}

	@RequestMapping(value = "/dairyAdmin/viewMilkSold", method = RequestMethod.GET)
	public ModelAndView listMilkSold(ModelMap modelMap, Principal principal) {
		String dairyAdminName = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminName);
		modelMap.addAttribute("milkSold", new MilkSold());
		modelMap.addAttribute("listMilkSold", this.milkSoldService.listMilkSold());
		ModelAndView sellModel = new ModelAndView();
		sellModel.addObject(modelMap);
		sellModel.addObject("message", "Fetched Milk successfully.");
		sellModel.setViewName("Admin/viewMilkSold");
		return sellModel;
	}

	@RequestMapping(value = "/dairyAdmin/milkSold/save", method = RequestMethod.POST)
	public String addMilkSold(@ModelAttribute("milkSold") MilkSold sell, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			if (sell.getSellId() == 0) {
				this.milkSoldService.addMilkSold(sell);
				redirectAttributes.addFlashAttribute("message", "Saved successfully");
			} else {
				this.milkSoldService.updateMilkSold(sell);
				redirectAttributes.addFlashAttribute("message", "Updated successfully");
			}
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Milk Sold not saved");
			logger.info("##########################################################################################" + ex);
		}

		return "redirect:/dairyAdmin/sellMilk";
	}

	@RequestMapping("/dairyAdmin/milkSold/remove/{sellId}")
	public String removeMilkSold(@PathVariable("sellId") Integer sellId, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			this.milkSoldService.removeMilkSold(sellId);
			redirectAttributes.addFlashAttribute("message", "Milk Sold Details was deleted successfully");
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Milk Sold Details was not deleted");
		}

		return "redirect:/dairyAdmin/viewMilkSold";
	}

}
