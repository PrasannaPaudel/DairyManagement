package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.muthaka.dairy.Models.MilkProduction;
import org.muthaka.dairy.service.MilkService;
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
 * Created by MUTHAKA on 2/24/2015.
 */
@Controller public class MilkController {

	private static final Logger logger = Logger.getLogger(MilkController.class);
	private MilkService milkService;

	@Autowired(required = true) @Qualifier(value = "milkService") public void setMealService(MilkService milkService1) {
		this.milkService = milkService1;
	}

	@RequestMapping(value = "/dairyAdmin/viewMilkProduction", method = RequestMethod.GET)
	public ModelAndView listMilkProduced(ModelMap modelMap, Principal principal) {
		String dairyAdminName = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminName);
		modelMap.addAttribute("milkProduced", new MilkProduction());
		modelMap.addAttribute("listMilkProduced", this.milkService.listMilkProduced());
		ModelAndView milkModel = new ModelAndView();
		milkModel.addObject(modelMap);
		milkModel.addObject("message", "Fetched Milk successfully.");
		milkModel.setViewName("Admin/viewMilkProduction");
		return milkModel;
	}



	@RequestMapping(value = "/dairyAdmin/viewGraphMilkProduction", method = RequestMethod.GET)
	public ModelAndView listGraphMilkProduced(ModelMap modelMap, Principal principal) {
		String dairyAdminName = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminName);
		modelMap.addAttribute("milkProduced", new MilkProduction());
		modelMap.addAttribute("listMilkProduced", this.milkService.listMilkProduced());
		ModelAndView milkModel = new ModelAndView();
		milkModel.addObject(modelMap);
		milkModel.addObject("message", "Fetched Milk successfully.");
		milkModel.setViewName("Admin/blankForm");
		return milkModel;
	}


	@RequestMapping(value = "/dairyAdmin/milkProduced/save", method = RequestMethod.POST)
	public String addMilk(@ModelAttribute("milkProduction") MilkProduction milk, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			if (milk.getMilkId() == 0) {
				this.milkService.addMilk(milk);
				redirectAttributes.addFlashAttribute("message", "Saved successfully");
			} else {
				this.milkService.updateMilk(milk);
				redirectAttributes.addFlashAttribute("message", "Updated successfully");
			}
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Milk not saved");
			logger.info("##########################################################################################" + ex);
		}

		return "redirect:/dairyAdmin/milkProduced";
	}

	@RequestMapping(value = "/dairyAdmin/milkProduced/edit", method = RequestMethod.POST)
	public String editMilk(@ModelAttribute("milkProduction") MilkProduction milk, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			if (milk.getMilkId() == 0) {
				this.milkService.addMilk(milk);
				redirectAttributes.addFlashAttribute("message", "Saved successfully");
			} else {
				this.milkService.updateMilk(milk);
				redirectAttributes.addFlashAttribute("message", "Updated successfully");
			}
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Milk not saved");
			logger.info("##########################################################################################" + ex);
		}

		return "redirect:/dairyAdmin/viewMilkProduction";
	}

	@RequestMapping("/dairyAdmin/milkProduced/remove/{MilkId}")
	public String removeMilk(@PathVariable("MilkId") Integer milkId, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			this.milkService.removeMilk(milkId);
			redirectAttributes.addFlashAttribute("message", "Milk Details was deleted successfully");
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Milk Details was not deleted");
		}

		return "redirect:/dairyAdmin/viewMilkProduction";
	}

}
