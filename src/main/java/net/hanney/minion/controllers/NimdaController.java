package net.hanney.minion.controllers;

import net.hanney.minion.model.DataCenter;
import net.hanney.minion.model.OperatingSystem;
import net.hanney.minion.model.ServerType;
import net.hanney.minion.service.NetworkService;
import net.hanney.minion.service.ServersService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Controller that handles all of the configuration administration for Minion
 *
 * @author justin.hanney
 */
@Controller
@RequestMapping(value = "/nimda")
public class NimdaController extends AbstractController {

    static final String VIEW_VARIABLE_CURRENT_NAVBAR_ITEM       = "currentNavbarItem";
    static final String VIEW_VARIABLE_DATA_CENTER               = "dataCenter";
    static final String VIEW_VARIABLE_DATA_CENTERS              = "dataCenters";
    static final String VIEW_VARIABLE_SERVER_TYPE               = "serverType";
    static final String VIEW_VARIABLE_SERVER_TYPES              = "serverTypes";
    static final String VIEW_VARIABLE_OPERATING_SYSTEMS         = "operatingSystems";

    static final String FORM_VARIABLE_TYPE_ID                   = "typeId";
    static final String FORM_VARIABLE_TYPE_CODE                 = "typeCode";
    static final String FORM_VARIABLE_TYPE_NAME                 = "typeName";
    static final String FORM_VARIABLE_CPU_CORES                 = "cpuCores";
    static final String FORM_VARIABLE_RAM_GB                    = "ramGb";
    static final String FORM_VARIABLE_HDD_GB                    = "hddGb";
    static final String FORM_VARIABLE_DATA_CENTER_ID            = "dataCenterId";
    static final String FORM_VARIABLE_DATA_CENTER_NAME          = "dataCenterName";
    static final String FORM_VARIABLE_OS_NAME                   = "operatingSystemName";

    @Autowired
    private NetworkService networkService;
    @Autowired
    private ServersService serversService;

    @RequestMapping(value = "/dc/create", method = RequestMethod.POST)
    public ModelAndView createDataCenter(final HttpServletRequest request) {
        final String dataCenterId   = request.getParameter(FORM_VARIABLE_DATA_CENTER_ID);
        final String dataCenterName = request.getParameter(FORM_VARIABLE_DATA_CENTER_NAME);

        final DataCenter dataCenter = new DataCenter();
        dataCenter.setDataCenterId(dataCenterId);
        dataCenter.setDataCenterName(dataCenterName);

        networkService.createDataCenter(dataCenter);

        return showDataCenters();
    }

    @RequestMapping(value = "/os/create", method = RequestMethod.POST)
    public ModelAndView createOperatingSystem(final HttpServletRequest request) {
        final String osName = request.getParameter(FORM_VARIABLE_OS_NAME);

        final OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setOperatingSystemName(osName);

        serversService.createOperatingSystem(operatingSystem);

        return showOperatingSystems();
    }

    @RequestMapping(value = "/type/create", method = RequestMethod.POST)
    public ModelAndView createServerType(final HttpServletRequest request) {
        final String typeCode  = request.getParameter(FORM_VARIABLE_TYPE_CODE);
        final String typeName  = request.getParameter(FORM_VARIABLE_TYPE_NAME);
        final Integer cpuCores = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_CPU_CORES));
        final BigDecimal ramGb = NumberUtils.createBigDecimal(request.getParameter(FORM_VARIABLE_RAM_GB));
        final BigDecimal hddGb = NumberUtils.createBigDecimal(request.getParameter(FORM_VARIABLE_HDD_GB));

        final ServerType serverType = new ServerType();
        serverType.setTypeCode(typeCode);
        serverType.setTypeName(typeName);
        serverType.setCpuCores(cpuCores);
        serverType.setRamGb(ramGb);
        serverType.setHddGb(hddGb);

        serversService.createServerType(serverType);

        return showServerTypes();
    }

    @RequestMapping(value = "/dc/update", method = RequestMethod.POST)
    public ModelAndView editDataCenter(final HttpServletRequest request) {
        final String dataCenterId   = request.getParameter(FORM_VARIABLE_DATA_CENTER_ID);
        final String dataCenterName = request.getParameter(FORM_VARIABLE_DATA_CENTER_NAME);

        final DataCenter dataCenter = networkService.getDataCenter(dataCenterId);
        dataCenter.setDataCenterName(dataCenterName);

        networkService.editDataCenter(dataCenter);

        return showDataCenters();
    }

    @RequestMapping(value = "/type/update", method = RequestMethod.POST)
    public ModelAndView editServerType(final HttpServletRequest request) {
        final Integer typeId   = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_TYPE_ID));
        final String typeCode  = request.getParameter(FORM_VARIABLE_TYPE_CODE);
        final String typeName  = request.getParameter(FORM_VARIABLE_TYPE_NAME);
        final Integer cpuCores = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_CPU_CORES));
        final BigDecimal ramGb = NumberUtils.createBigDecimal(request.getParameter(FORM_VARIABLE_RAM_GB));
        final BigDecimal hddGb = NumberUtils.createBigDecimal(request.getParameter(FORM_VARIABLE_HDD_GB));

        final ServerType serverType = serversService.getServerType(typeId);
        serverType.setTypeCode(typeCode);
        serverType.setTypeName(typeName);
        serverType.setCpuCores(cpuCores);
        serverType.setRamGb(ramGb);
        serverType.setHddGb(hddGb);

        serversService.editServerType(serverType);

        return showServerTypes();
    }

    @Override
    public NavbarItem getSelectedNavbarItem() {
        return NavbarItem.NIMDA;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return showServerTypes();
    }

    @RequestMapping(value = "/dc", method = RequestMethod.GET)
    public ModelAndView showDataCenters() {
        final ModelAndView mv = new ModelAndView("nimda/showDataCenters");
        setCurrentNavbarItem(mv, NimdaNavbarItem.DATA_CENTERS);

        // Load all of the active Data Centers
        final List<DataCenter> dataCenters = networkService.getActiveDataCenters();
        mv.addObject(VIEW_VARIABLE_DATA_CENTERS, dataCenters);

        return mv;
    }

    @RequestMapping(value = "/dc/{dataCenterId}/edit", method = RequestMethod.GET)
    public ModelAndView showEditDataCenter(final @PathVariable String dataCenterId) {
        final ModelAndView mv = new ModelAndView("nimda/editDataCenter");
        setCurrentNavbarItem(mv, NimdaNavbarItem.DATA_CENTERS);

        // Load the actual ServerType to edit
        final DataCenter dataCenter = networkService.getDataCenter(dataCenterId);
        mv.addObject(VIEW_VARIABLE_DATA_CENTER, dataCenter);

        return mv;
    }

    @RequestMapping(value = "/type/{typeId}/edit", method = RequestMethod.GET)
    public ModelAndView showEditServerType(final @PathVariable Integer typeId) {
        final ModelAndView mv = new ModelAndView("nimda/editServerType");
        setCurrentNavbarItem(mv, NimdaNavbarItem.SERVER_TYPES);

        // Load the actual ServerType to edit
        final ServerType serverType = serversService.getServerType(typeId);
        mv.addObject(VIEW_VARIABLE_SERVER_TYPE, serverType);

        return mv;
    }

    @RequestMapping(value = "/dc/new", method = RequestMethod.GET)
    public ModelAndView showNewDataCenter() {
        final ModelAndView mv = new ModelAndView("nimda/newDataCenter");
        setCurrentNavbarItem(mv, NimdaNavbarItem.DATA_CENTERS);

        return mv;
    }

    @RequestMapping(value = "/os/new", method = RequestMethod.GET)
    public ModelAndView showNewOperatingSystem() {
        final ModelAndView mv = new ModelAndView("nimda/newOperatingSystem");
        setCurrentNavbarItem(mv, NimdaNavbarItem.OPERATING_SYSTEMS);

        return mv;
    }

    @RequestMapping(value = "/type/new", method = RequestMethod.GET)
    public ModelAndView showNewServerType() {
        final ModelAndView mv = new ModelAndView("nimda/newServerType");
        setCurrentNavbarItem(mv, NimdaNavbarItem.SERVER_TYPES);

        return mv;
    }

    @RequestMapping(value = "/os", method = RequestMethod.GET)
    public ModelAndView showOperatingSystems() {
        final ModelAndView mv = new ModelAndView("nimda/showOperatingSystems");
        setCurrentNavbarItem(mv, NimdaNavbarItem.OPERATING_SYSTEMS);

        // Load all of the active Operating Systems
        final List<OperatingSystem> operatingSystems = serversService.getOperatingSystems();
        mv.addObject(VIEW_VARIABLE_OPERATING_SYSTEMS, operatingSystems);

        return mv;
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public ModelAndView showServerTypes() {
        final ModelAndView mv = new ModelAndView("nimda/showServerTypes");
        setCurrentNavbarItem(mv, NimdaNavbarItem.SERVER_TYPES);

        // Load all of the active Server Types
        final List<ServerType> serverTypes = serversService.getServerTypes();
        mv.addObject(VIEW_VARIABLE_SERVER_TYPES, serverTypes);

        return mv;
    }

    void setCurrentNavbarItem(final ModelAndView mv, final NimdaNavbarItem navbarItem) {
        mv.addObject(VIEW_VARIABLE_CURRENT_NAVBAR_ITEM, navbarItem);
    }

}
