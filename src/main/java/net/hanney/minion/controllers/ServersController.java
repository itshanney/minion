package net.hanney.minion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Primary Controller that handles all Servers-related functionality
 *
 * @author justin.hanney
 */
@Controller
@RequestMapping(value = "/servers")
public class ServersController {


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView();
    }

}
