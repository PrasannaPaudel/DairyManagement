package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.muthaka.dairy.Models.Users;
import org.muthaka.dairy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * Created by MUTHAKA on 3/6/2015.
 */
@Controller public class UsersController {

    private static final Logger logger = Logger.getLogger(UsersController.class);
    private UsersService usersService;

    @Autowired(required = true) @Qualifier(value = "usersService")
    public void setUsersService(UsersService userService1) {
        this.usersService = userService1;
    }

    @RequestMapping(value = "/dairyAdmin/UserRegistration", method = RequestMethod.GET)
    public ModelAndView listUsers(ModelMap modelMap, Principal principal) {
        String dairyAdminName = principal.getName();
        modelMap.addAttribute("dairyAdminNm", dairyAdminName);
        modelMap.addAttribute("users", new UsersController());
        modelMap.addAttribute("listUsers", this.usersService.listUser());
        ModelAndView userModel = new ModelAndView();
        userModel.addObject(modelMap);
        userModel.addObject("message", "Fetched Users successfully.");
        userModel.setViewName("Admin/registerUserForm");
        return userModel;
    }

    @RequestMapping(value = "/dairyAdmin/RegisterUsers/save", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("users") Users user, RedirectAttributes redirectAttributes)
            throws RuntimeException {
        try {
            if (user.getUserId() == 0) {
                this.usersService.addUser(user);
                redirectAttributes.addFlashAttribute("message", "Saved successfully");
            } else {
                this.usersService.updateUser(user);
                redirectAttributes.addFlashAttribute("message", "Updated successfully");
            }
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", "User not saved");
            logger.info("##########################################################################################" + ex);
        }

        return "redirect:/dairyAdmin/userRegistration";
    }

}
