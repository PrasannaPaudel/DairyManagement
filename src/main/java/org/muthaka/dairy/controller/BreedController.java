package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.muthaka.dairy.Models.Breeding;
import org.muthaka.dairy.service.BreedService;
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
@Controller
public class BreedController {

    private static final Logger logger = Logger.getLogger(BreedController.class);
    private BreedService breedService;

    @Autowired(required = true) @Qualifier(value = "breedService")
    public void setBreedService(BreedService breedService1) {
        this.breedService = breedService1;
    }

    @RequestMapping(value = "/dairyAdmin/viewBreeding", method = RequestMethod.GET)
    public ModelAndView listBreed(ModelMap modelMap, Principal principal) {
        String dairyAdminName = principal.getName();
        modelMap.addAttribute("dairyAdminNm", dairyAdminName);
        modelMap.addAttribute("breeding", new Breeding());
        modelMap.addAttribute("listBreeding", this.breedService.listBreed());
        ModelAndView breedModel = new ModelAndView();
        breedModel.addObject(modelMap);
        breedModel.addObject("message", "Fetched Breed successfully.");
        breedModel.setViewName("Admin/viewBreeding");
        return breedModel;
    }

    @RequestMapping(value = "/dairyAdmin/breeding/save", method = RequestMethod.POST)
    public String addBreed(@ModelAttribute("breeding") Breeding breeding, RedirectAttributes redirectAttributes)
            throws RuntimeException {
        try {
            if (breeding.getBreedId() == 0) {
                this.breedService.addBreed(breeding);
                redirectAttributes.addFlashAttribute("message", "Saved successfully");
            } else {
                this.breedService.updateBreed(breeding);
                redirectAttributes.addFlashAttribute("message", "Updated successfully");
            }
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", "Breed not saved");
            logger.info("##########################################################################################" + ex);
        }

        return "redirect:/dairyAdmin/breeding";
    }

    @RequestMapping("/dairyAdmin/breeding/remove/{breedId}")
    public String removeBreed(@PathVariable("breedId") Integer breedId, RedirectAttributes redirectAttributes)
            throws RuntimeException {
        try {
            this.breedService.removeBreed(breedId);
            redirectAttributes.addFlashAttribute("message", "Breed Details was deleted successfully");
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", "Breed Details was not deleted");
        }

        return "redirect:/dairyAdmin/viewBreedingTable";
    }


}
