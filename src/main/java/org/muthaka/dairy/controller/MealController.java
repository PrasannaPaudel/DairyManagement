package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.muthaka.dairy.Models.DairyFeeds;
import org.muthaka.dairy.service.MealService;
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
@Controller public class MealController {

	private static final Logger logger = Logger.getLogger(MealController.class);
	private MealService mealService;

	@Autowired(required = true) @Qualifier(value = "mealService") public void setMealService(MealService mealService1) {
		this.mealService = mealService1;
	}

	@RequestMapping(value = "/dairyAdmin/viewFeeds", method = RequestMethod.GET)
	public ModelAndView listDairyFeeds(ModelMap modelMap, Principal principal) {
		String dairyAdminName = principal.getName();
		modelMap.addAttribute("dairyAdminNm", dairyAdminName);
		modelMap.addAttribute("dairyFeeds", new DairyFeeds());
		modelMap.addAttribute("listDairyFeeds", this.mealService.listDairyFeeds());
		ModelAndView mealModel = new ModelAndView();
		mealModel.addObject(modelMap);
		mealModel.addObject("message", "Fetched Feeds successfully.");
		mealModel.setViewName("Admin/viewFeeds");
		return mealModel;
	}

	@RequestMapping(value = "/dairyAdmin/mealTaken/save", method = RequestMethod.POST)
	public String addFeed(@ModelAttribute("dairyFeeds") DairyFeeds dairyfeeds, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			if (dairyfeeds.getDairyId() == 0) {
				this.mealService.addFeeds(dairyfeeds);
				redirectAttributes.addFlashAttribute("message", "Saved successfully");
			} else {
				this.mealService.updateFeeds(dairyfeeds);
				redirectAttributes.addFlashAttribute("message", "Updated successfully");
			}
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Feeds not saved");
			logger.info("##########################################################################################" + ex);
		}

		return "redirect:/dairyAdmin/mealTaken";
	}

	@RequestMapping("/dairyAdmin/mealTaken/remove/{dairyId}")
	public String removeMilk(@PathVariable("dairyId") Integer FeedId, RedirectAttributes redirectAttributes)
			throws RuntimeException {
		try {
			this.mealService.removeFeed(FeedId);
			redirectAttributes.addFlashAttribute("message", "Feed Details was deleted successfully");
		} catch (RuntimeException ex) {
			redirectAttributes.addFlashAttribute("error", "Feed Details was not deleted");
		}

		return "redirect:/dairyAdmin/viewFeeds";
	}

}
