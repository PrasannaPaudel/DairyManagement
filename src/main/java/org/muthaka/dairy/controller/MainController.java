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
@Controller
public class MainController {
    private static final Logger logs = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/mainLogin", method = RequestMethod.GET)
    public ModelAndView getLoginForm(@RequestParam(required = false) String authfailed, String logout, String denied) {

        ModelAndView model = new ModelAndView();
        if (authfailed != null) {
            model.addObject("error", "Invalid login credentials");
            logs.info("Invalid username or password, try again !");
        } else if (logout != null) {
            model.addObject("message", "You've been logged out successfully.");
            logs.info("Logged Out successfully");
        }
        if (denied != null) {
            model.addObject("error", "Access Denied");
            logs.info("User access denied");
        }
        model.setViewName("mainLogin");
        return model;
    }

    @RequestMapping(value = "/dairyAdmin", method = RequestMethod.GET)
    public ModelAndView getChurchAdminPage(ModelMap modelMap, Principal principal) {
        String dairyAdminNm = principal.getName();
        modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
        ModelAndView dairyAdminModel = new ModelAndView();
        dairyAdminModel.addObject(modelMap);
        dairyAdminModel.setViewName("Admin/dairyAdmin");
        return dairyAdminModel;
    }

    @RequestMapping(value = "/dairyWorker", method = RequestMethod.GET)
    public ModelAndView getSchoolAdmin(ModelMap modelMap, Principal principal) {
        String DairyWorker = principal.getName();
        modelMap.addAttribute("DairyWorker", DairyWorker);
        ModelAndView dairyWorkerModel = new ModelAndView();
        dairyWorkerModel.addObject(modelMap);
        dairyWorkerModel.setViewName("dairyWorker");
        return dairyWorkerModel;
    }


   @RequestMapping(value = "/error", method = RequestMethod.GET) public String getErrorPage() {
      return "/WEB-INF/500.jsp";
    }

    @RequestMapping(value = "/dairyAdmin/registerCows", method = RequestMethod.GET )
    public  ModelAndView getCowRegistration(ModelMap modelMap, Principal principal) {
        String dairyAdminNm =  principal.getName();
        modelMap.addAttribute("dairyAdminNm", dairyAdminNm);
        ModelAndView dairyAdminModel = new ModelAndView();
        dairyAdminModel.addObject(modelMap);
        dairyAdminModel.setViewName("Admin/registerForm");
        return  dairyAdminModel;
    }
}



