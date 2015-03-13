package org.muthaka.dairy.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MUTHAKA on 1/28/2015.
 */
@Controller
public class RedirectController {
    public static final Logger logs = Logger.getLogger(RedirectController.class);

    @RequestMapping("/default") public String loginRedirect(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_FIRMADMIN")) {
            logs.info("Admin successfully logged in");
            return "redirect:dairyAdmin";
        } else if (request.isUserInRole("ROLE_FIRMWORKER")) {
            logs.info("User succesfully logged in");
            return "redirect:dairyWorker";
        }
        logs.info("unknown user log in");
        return "redirect:/error";
    }
}





