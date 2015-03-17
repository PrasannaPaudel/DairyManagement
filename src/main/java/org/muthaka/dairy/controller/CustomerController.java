package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.muthaka.dairy.Models.Customers;
import org.muthaka.dairy.service.CustomerService;
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
@Controller public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	private CustomerService customerService;

	@Autowired(required = true) @Qualifier(value = "customerService")
	public void setCustomerService(CustomerService customerService1) {
		this.customerService = customerService1;
	}

	@RequestMapping(value = "/dairyAdmin/viewCustomer", method = RequestMethod.GET)
	public ModelAndView listCustomer(ModelMap modelMap, Principal principal) {
		String dairyAdminName = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminName);
		modelMap.addAttribute("customer", new Customers());
		modelMap.addAttribute("listCustomer", this.customerService.listCustomer());
		ModelAndView customerModel = new ModelAndView();
		customerModel.addObject(modelMap);
		customerModel.addObject("message", "Fetched Customer successfully.");
		customerModel.setViewName("Admin/viewCustomer");
		return customerModel;
	}

	@RequestMapping(value = "/dairyAdmin/Customer/save", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customers customers, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			if (customers.getCustomerId() == 0) {
				this.customerService.addCustomer(customers);
				redirectAttributes.addFlashAttribute("message", "Saved successfully");
			} else {
				this.customerService.updateCustomer(customers);
				redirectAttributes.addFlashAttribute("message", "Updated successfully");
			}
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Customer not saved");
			logger.info("##########################################################################################" + ex);
		}

		return "redirect:/dairyAdmin/customerRegistration";
	}

	@RequestMapping("/dairyAdmin/Customer/remove/{customerId}")
	public String removeCustomer(@PathVariable("customerId") Integer customerId, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			this.customerService.removeCustomer(customerId);
			redirectAttributes.addFlashAttribute("message", "Customer Details was deleted successfully");
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Customer Details was not deleted");
		}

		return "redirect:/dairyAdmin/viewCustomer";
	}

}
