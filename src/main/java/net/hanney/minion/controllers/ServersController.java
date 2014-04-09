package net.hanney.minion.controllers;

import net.hanney.minion.model.DataCenter;
import net.hanney.minion.model.OperatingSystem;
import net.hanney.minion.model.Server;
import net.hanney.minion.model.ServerType;
import net.hanney.minion.service.NetworkService;
import net.hanney.minion.service.ServersService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    static final String VIEW_VARIABLE_OPERATING_SYSTEMS         = "operatingSystems";
    static final String VIEW_VARIABLE_SERVER_TYPES              = "serverTypes";
    static final String VIEW_VARIABLE_DATA_CENTERS              = "dataCenters";

    static final String FORM_VARIABLE_OPERATING_SYSTEM          = "operatingSystem";
    static final String FORM_VARIABLE_SERVER_TYPE               = "serverType";
    static final String FORM_VARIABLE_DATA_CENTER               = "dataCenter";
    static final String FORM_VARIABLE_HOSTNAME                  = "hostname";

    @Autowired
    private NetworkService networkService;
    @Autowired
    private ServersService serversService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createServer(final HttpServletRequest request) {
        final String hostname         = request.getParameter(FORM_VARIABLE_HOSTNAME);
        final String dataCenter       = request.getParameter(FORM_VARIABLE_DATA_CENTER);
        final Integer operatingSystem = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_OPERATING_SYSTEM));
        final Integer serverType      = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_SERVER_TYPE));

        final Server server = new Server();
        server.setHostname(hostname);
        server.setDataCenterId(dataCenter);
        server.setServerTypeId(serverType);
        server.setOperatingSystemId(operatingSystem);

        serversService.createServer(server);

        return showServers();
    }

    @Override
    public NavbarItem getSelectedNavbarItem() {
        return NavbarItem.SERVERS;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return showServers();
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView showNewServer() {
        final ModelAndView mv = new ModelAndView("servers/newServer");

        final List<OperatingSystem> operatingSystems = serversService.getOperatingSystems();
        mv.addObject(VIEW_VARIABLE_OPERATING_SYSTEMS, operatingSystems);

        final List<ServerType> serverTypes = serversService.getServerTypes();
        mv.addObject(VIEW_VARIABLE_SERVER_TYPES, serverTypes);

        final List<DataCenter> dataCenters = networkService.getActiveDataCenters();
        mv.addObject(VIEW_VARIABLE_DATA_CENTERS, dataCenters);

        return mv;
    }

    public ModelAndView showServers() {
        final ModelAndView mv = new ModelAndView("servers/showServers");

        // Load all of the active Servers
        final List<Server> servers = serversService.getServers();
        mv.addObject(VIEW_VARIABLE_SERVERS, servers);

        return mv;
    }

}
