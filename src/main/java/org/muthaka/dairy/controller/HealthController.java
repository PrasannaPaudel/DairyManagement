package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.muthaka.dairy.Models.Health;
import org.muthaka.dairy.service.HealthService;
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
 * Created by MUTHAKA on 3/9/2015.
 */
@Controller
public class HealthController {

    private static final Logger logger = Logger.getLogger(HealthController.class);
    private HealthService healthService;

    @Autowired(required = true) @Qualifier(value = "healthService")
    public void setHealthService(HealthService healthService1) {
        this.healthService = healthService1;
    }

    @RequestMapping(value = "/dairyAdmin/viewHealth", method = RequestMethod.GET)
    public ModelAndView listHealth(ModelMap modelMap, Principal principal) {
        String dairyAdminName = principal.getName();
        modelMap.addAttribute("dairyAdminNm", dairyAdminName);
        modelMap.addAttribute("health", new Health());
        modelMap.addAttribute("listHealth", this.healthService.listHealth());
        ModelAndView healthModel = new ModelAndView();
        healthModel.addObject(modelMap);
        healthModel.addObject("message", "Fetched Health successfully.");
        healthModel.setViewName("Admin/viewHealth");
        return healthModel;
    }

    @RequestMapping(value = "/dairyAdmin/CowHealth/save", method = RequestMethod.POST)
    public String addHealth(@ModelAttribute("health") Health health, RedirectAttributes redirectAttributes)
            throws RuntimeException {
        try {
            if (health.getHealthId() == 0) {
                this.healthService.addHealth(health);
                redirectAttributes.addFlashAttribute("message", "Saved successfully");
            } else {
                this.healthService.updateHealth(health);
                redirectAttributes.addFlashAttribute("message", "Updated successfully");
            }
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", "Health not saved");
            logger.info("##########################################################################################" + ex);
        }

        return "redirect:/dairyAdmin/cowHealth";
    }

    @RequestMapping("/dairyAdmin/CowHealth/remove/{healthId}")
    public String removeHealth(@PathVariable("healthId") Integer healthId, RedirectAttributes redirectAttributes)
            throws RuntimeException {
        try {
            this.healthService.removeHealth(healthId);
            redirectAttributes.addFlashAttribute("message", "Health Details was deleted successfully");
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", "Health Details was not deleted");
        }

        return "redirect:/dairyAdmin/viewHealthTable";
    }





}
