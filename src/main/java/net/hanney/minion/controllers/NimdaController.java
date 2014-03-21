package net.hanney.minion.controllers;

import net.hanney.minion.model.ServerType;
import net.hanney.minion.service.NimdaService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Controller that handles all of the configuration administration for Minion
 *
 * @author justin.hanney
 */
@Controller
@RequestMapping(value = "/nimda")
public class NimdaController {

    static final String VIEW_VARIABLE_CURRENT_NAVBAR_ITEM       = "currentNavbarItem";
    static final String VIEW_VARIABLE_SERVER_TYPE               = "serverType";
    static final String VIEW_VARIABLE_SERVER_TYPES              = "serverTypes";

    static final String FORM_VARIABLE_TYPE_ID                   = "typeId";
    static final String FORM_VARIABLE_TYPE_NAME                 = "typeName";
    static final String FORM_VARIABLE_CPU_CORES                 = "cpuCores";
    static final String FORM_VARIABLE_RAM_GB                    = "ramGb";
    static final String FORM_VARIABLE_HDD_GB                    = "hddGb";

    @Autowired
    private NimdaService nimdaService;

    @RequestMapping(value = "/type/create", method = RequestMethod.POST)
    public ModelAndView createServerType(final HttpServletRequest request) {
        final String typeId    = request.getParameter(FORM_VARIABLE_TYPE_ID);
        final String typeName  = request.getParameter(FORM_VARIABLE_TYPE_NAME);
        final Integer cpuCores = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_CPU_CORES));
        final BigDecimal ramGb = NumberUtils.createBigDecimal(request.getParameter(FORM_VARIABLE_RAM_GB));
        final BigDecimal hddGb = NumberUtils.createBigDecimal(request.getParameter(FORM_VARIABLE_HDD_GB));

        final ServerType serverType = new ServerType();
        serverType.setTypeId(typeId);
        serverType.setTypeName(typeName);
        serverType.setCpuCores(cpuCores);
        serverType.setRamGb(ramGb);
        serverType.setHddGb(hddGb);

        nimdaService.createServerType(serverType);

        return showServerTypes();
    }

    @RequestMapping(value = "/type/update", method = RequestMethod.POST)
    public ModelAndView editServerType(final HttpServletRequest request) {
        final String typeId    = request.getParameter(FORM_VARIABLE_TYPE_ID);
        final String typeName  = request.getParameter(FORM_VARIABLE_TYPE_NAME);
        final Integer cpuCores = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_CPU_CORES));
        final BigDecimal ramGb = NumberUtils.createBigDecimal(request.getParameter(FORM_VARIABLE_RAM_GB));
        final BigDecimal hddGb = NumberUtils.createBigDecimal(request.getParameter(FORM_VARIABLE_HDD_GB));

        final ServerType serverType = nimdaService.getServerType(typeId);
        serverType.setTypeName(typeName);
        serverType.setCpuCores(cpuCores);
        serverType.setRamGb(ramGb);
        serverType.setHddGb(hddGb);

        nimdaService.editServerType(serverType);

        return showServerTypes();
    }

    @ModelAttribute(value = "nimdaNavbarItems")
    public List<NimdaNavbarItem> getNimdaNavbarItems() {
        return Arrays.asList(NimdaNavbarItem.values());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return showServerTypes();
    }

    @RequestMapping(value = "/type/{typeId}/edit", method = RequestMethod.GET)
    public ModelAndView showEditServerType(final @PathVariable String typeId) {
        final ModelAndView mv = new ModelAndView("nimda/editServerType");
        setCurrentNavbarItem(mv, NimdaNavbarItem.SERVER_TYPES);

        // Load the actual ServerType to edit
        final ServerType serverType = nimdaService.getServerType(typeId);
        mv.addObject(VIEW_VARIABLE_SERVER_TYPE, serverType);

        return mv;
    }

    @RequestMapping(value = "/type/new", method = RequestMethod.GET)
    public ModelAndView showNewServerType() {
        final ModelAndView mv = new ModelAndView("nimda/newServerType");
        setCurrentNavbarItem(mv, NimdaNavbarItem.SERVER_TYPES);

        return mv;
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public ModelAndView showServerTypes() {
        final ModelAndView mv = new ModelAndView("nimda/showServerTypes");
        setCurrentNavbarItem(mv, NimdaNavbarItem.SERVER_TYPES);

        // Load all of the active Server Types
        final List<ServerType> serverTypes = nimdaService.getActiveServerTypes();
        mv.addObject(VIEW_VARIABLE_SERVER_TYPES, serverTypes);

        return mv;
    }

    void setCurrentNavbarItem(final ModelAndView mv, final NimdaNavbarItem navbarItem) {
        mv.addObject(VIEW_VARIABLE_CURRENT_NAVBAR_ITEM, navbarItem);
    }

}
