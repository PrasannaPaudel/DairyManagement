package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by MUTHAKA on 1/28/2015.
 */
@Controller public class MainController {
	private static final Logger logs = Logger.getLogger(MainController.class);

	@RequestMapping(value = "/mainLogin", method = RequestMethod.GET)
	public ModelAndView getLoginForm(@RequestParam(required = false) String authfailed, String logout, String denied,
			String sessionExpired) {

		ModelAndView model = new ModelAndView();
		if (authfailed != null) {
			model.addObject("error", "Invalid login credentials");
			logs.info("Invalid username or password, try again !");
		} else if (logout != null) {
			model.addObject("message", "You've been logged out successfully.");
			logs.info("Logged Out successfully");
		} else if (sessionExpired != null) {
			model.addObject("error", "Session Expired. Please login to continue");
			logs.info("Session Expired");
		}
		if (denied != null) {
			model.addObject("error", "Access Denied");
			logs.info("User access denied");
		}
		model.setViewName("mainLogin");
		return model;
	}

	@RequestMapping(value = "/dairyAdmin", method = RequestMethod.GET)
	public ModelAndView getDairyAdmin(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/dairyAdmin");
		return dairyAdminModel;
	}

	@RequestMapping(value = "/dairyWorker", method = RequestMethod.GET)
	public ModelAndView getDairyWorker(ModelMap modelMap, Principal principal) {
		String DairyWorker = principal.getName();
		modelMap.addAttribute("DairyWorker", DairyWorker);
		ModelAndView dairyWorkerModel = new ModelAndView();
		dairyWorkerModel.addObject(modelMap);
		dairyWorkerModel.setViewName("Worker/dairyWorker");
		return dairyWorkerModel;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET) public String getErrorPage() {
		return "/WEB-INF/500.jsp";
	}

	@RequestMapping(value = "/dairyAdmin/registerCows", method = RequestMethod.GET)
	public ModelAndView getCowRegistration(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/registerForm");
		return dairyAdminModel;
	}

	@RequestMapping(value = "/dairyAdmin/milkProduced", method = RequestMethod.GET)
	public ModelAndView getMilkProduced(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/milkForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/mealTaken", method = RequestMethod.GET)
	public ModelAndView getMeal(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/mealForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/cowHealth", method = RequestMethod.GET)
	public ModelAndView getHealth(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/healthForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/sellMilk", method = RequestMethod.GET)
	public ModelAndView getSellMilk(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/sellMilkForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/breeding", method = RequestMethod.GET)
	public ModelAndView getBreed(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/breedForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/adminRegistration", method = RequestMethod.GET)
	public ModelAndView getRegisterAdmin(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/registerAdminForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/workerRegistration", method = RequestMethod.GET)
	public ModelAndView getRegisterWorker(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/registerWorkerForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/userRegistration", method = RequestMethod.GET)
	public ModelAndView getRegisterUser(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/registerUserForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/staffRegistration", method = RequestMethod.GET)
	public ModelAndView getRegisterStaff(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/registerStaffForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/customerRegistration", method = RequestMethod.GET)
	public ModelAndView getRegisterCustomer(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/registerCustomer");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/blankPage", method = RequestMethod.GET)
	public ModelAndView getBlank(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/blankForm");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/rtlForm", method = RequestMethod.GET)
	public ModelAndView getRtl(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/rtl");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/viewBreedingTable", method = RequestMethod.GET)
	public ModelAndView getViewBreed(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/viewBreeding");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/viewCustomerTable", method = RequestMethod.GET)
	public ModelAndView getViewCustomer(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/viewCustomer");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/viewFeedsTable", method = RequestMethod.GET)
	public ModelAndView getViewFeed(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/viewFeeds");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/viewFinanceTable", method = RequestMethod.GET)
	public ModelAndView getViewFinance(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/viewFinance");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/viewHealthTable", method = RequestMethod.GET)
	public ModelAndView getViewHealth(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/viewHealth");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/viewHerdTable", method = RequestMethod.GET)
	public ModelAndView getViewHerd(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/viewHerd");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/viewMilkProductionTable", method = RequestMethod.GET)
	public ModelAndView getViewMilkProduction(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/viewMilkProduction");
		return dairyAdminModel;

	}

	@RequestMapping(value = "/dairyAdmin/viewWorkersTable", method = RequestMethod.GET)
	public ModelAndView getViewWorkers(ModelMap modelMap, Principal principal) {
		String dairyAdminNm = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
		ModelAndView dairyAdminModel = new ModelAndView();
		dairyAdminModel.addObject(modelMap);
		dairyAdminModel.setViewName("Admin/viewWorkers");
		return dairyAdminModel;

	}

}


