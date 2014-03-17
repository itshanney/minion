package net.hanney.minion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller that handles all of the configuration administration for Minion
 *
 * @author justin.hanney
 */
@Controller
@RequestMapping(value = "/nimda")
public class NimdaController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("nimda/index");
    }

}
