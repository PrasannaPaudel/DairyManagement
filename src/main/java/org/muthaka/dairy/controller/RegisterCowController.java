package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.muthaka.dairy.Models.CowRegistration;
import org.muthaka.dairy.service.RegisterCowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
@Controller public class RegisterCowController {
	private static final Logger logger = Logger.getLogger(RegisterCowController.class);
	private RegisterCowService registerCowService;

	@Autowired(required = true) @Qualifier(value = "registerCowService")
	public void setRegisterCowService(RegisterCowService cowService1) {
		this.registerCowService = cowService1;
	}

	@RequestMapping(value = "/dairyAdmin/viewHerd", method = RequestMethod.GET)
	public ModelAndView listCowReg(ModelMap modelMap, Principal principal) {
		String dairyAdminName = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminName);
		modelMap.addAttribute("dairyCows", new CowRegistration());
		modelMap.addAttribute("listCows", this.registerCowService.listCowReg());
		ModelAndView cowModel = new ModelAndView();
		cowModel.addObject(modelMap);
		cowModel.addObject("message", "Fetched Cows successfully.");
		cowModel.setViewName("Admin/registerForm");
		return cowModel;
	}

	@RequestMapping(value = "/dairyAdmin/viewCowsHerd", method = RequestMethod.GET)
	public ModelAndView listCows(ModelMap modelMap, Principal principal) {
		String dairyAdminName = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminName);
		modelMap.addAttribute("dairyCows", new CowRegistration());
		modelMap.addAttribute("listCows", this.registerCowService.listCowReg());
		ModelAndView cowModel = new ModelAndView();
		cowModel.addObject(modelMap);
		cowModel.addObject("message", "Fetched Cows successfully.");
		cowModel.setViewName("Admin/viewHerd");
		return cowModel;
	}

	@RequestMapping(value = "/dairyAdmin/registerCows/save", method = RequestMethod.POST)
	public String addCow(@ModelAttribute("cowRegistration") CowRegistration cow, RedirectAttributes redirectAttributes,
			BindingResult bindingResult) throws RuntimeException {
		try {
			if (cow.getCowId() == 0) {
				if (bindingResult.hasErrors()) {
					return "redirect:/dairyAdmin/registerCows";
				} else {
					this.registerCowService.addCow(cow);
					redirectAttributes.addFlashAttribute("message", "Cow added successfully");
				}
			} else {
				this.registerCowService.updateCow(cow);
				redirectAttributes.addFlashAttribute("message", "Updated successfully");
			}
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Cow not saved");
			logger.info("##########################################################################################" + ex);
		}

		return "redirect:/dairyAdmin/viewHerd";
	}

	@RequestMapping("/dairyAdmin/registerCows/remove/{cowId}")
	public String removeCow(@PathVariable("cowId") Integer cowId, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			this.registerCowService.removeCow(cowId);
			redirectAttributes.addFlashAttribute("message", "Cow Details was deleted successfully");
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Cow Details was not deleted");
		}

		return "redirect:/dairyAdmin/viewHerd";
	}

}
