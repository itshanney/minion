package net.hanney.minion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller than handles all Identity Authentication-related actions
 *
 * @author justin.hanney
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("auth/login");
    }

}
