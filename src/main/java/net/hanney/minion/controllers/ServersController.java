package net.hanney.minion.controllers;

import net.hanney.minion.model.Server;
import net.hanney.minion.service.ServersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Primary Controller that handles all Servers-related functionality
 *
 * @author justin.hanney
 */
@Controller
@RequestMapping(value = "/servers")
public class ServersController extends AbstractController {

    static final String VIEW_VARIABLE_SERVERS                   = "servers";

    @Autowired
    private ServersService serversService;

    @Override
    public NavbarItem getSelectedNavbarItem() {
        return NavbarItem.SERVERS;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return showServers();
    }

    public ModelAndView showServers() {
        final ModelAndView mv = new ModelAndView("servers/showServers");

        // Load all of the active Servers
        final List<Server> servers = serversService.getServers();
        mv.addObject(VIEW_VARIABLE_SERVERS, servers);

        return mv;
    }

}
