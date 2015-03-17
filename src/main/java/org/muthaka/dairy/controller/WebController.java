package org.muthaka.dairy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MUTHAKA on 1/28/2015.
 */
@Controller public class WebController {
	@RequestMapping(value = "/passwordRecovery", method = RequestMethod.GET) public String forgotPaswordPasge() {
		return "forgotPassword";
	}
}
