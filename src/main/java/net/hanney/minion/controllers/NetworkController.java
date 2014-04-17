package net.hanney.minion.controllers;

import net.hanney.minion.model.DnsRecord;
import net.hanney.minion.model.SslCertificate;
import net.hanney.minion.model.Domain;
import net.hanney.minion.service.NetworkService;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Primary Controller that handles all Network-related functionality
 *
 * @author justin.hanney
 */
@Controller
@RequestMapping(value = "/network")
public class NetworkController extends AbstractController {

    static final String VIEW_VARIABLE_CURRENT_NAVBAR_ITEM               = "currentNavbarItem";
    static final String VIEW_VARIABLE_SSL_CERTIFICATES                  = "sslCertificates";
    static final String VIEW_VARIABLE_DOMAINS                           = "domains";
    static final String VIEW_VARIABLE_DNS_RECORDS                       = "dnsRecords";

    static final String FORM_VARIABLE_CERTIFICATE_NAME                  = "certificateName";
    static final String FORM_VARIABLE_DOMAIN_ID                         = "domainId";
    static final String FORM_VARIABLE_DNS_NAME                          = "name";
    static final String FORM_VARIABLE_DNS_VALUE                         = "value";
    static final String FORM_VARIAVLE_DNS_TYPE                          = "type";

    @Autowired
    private NetworkService networkService;

    @RequestMapping(value = "/dns/create", method = RequestMethod.POST)
    public ModelAndView createDnsRecord(final HttpServletRequest request) {
        final String name      = request.getParameter(FORM_VARIABLE_DNS_NAME);
        final Integer domainId = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_DOMAIN_ID));
        final String value     = request.getParameter(FORM_VARIABLE_DNS_VALUE);
        final String type      = request.getParameter(FORM_VARIAVLE_DNS_TYPE);

        final DnsRecord dnsRecord = new DnsRecord();
        dnsRecord.setName(name);
        dnsRecord.setDomainId(domainId);
        dnsRecord.setType(type);
        dnsRecord.setValue(value);

        networkService.createDnsRecord(dnsRecord);

        return showDnsRecords();
    }

    @RequestMapping(value = "/cert/create", method = RequestMethod.POST)
    public ModelAndView createSslCertificate(final HttpServletRequest request) {
        final String certificateName = request.getParameter(FORM_VARIABLE_CERTIFICATE_NAME);
        final Integer domainId       = NumberUtils.createInteger(request.getParameter(FORM_VARIABLE_DOMAIN_ID));

        final SslCertificate certificate = new SslCertificate();
        certificate.setCertificateName(certificateName);
        certificate.setDomainId(domainId);
        certificate.setExpirationDate(new DateTime().plusYears(1).toDate());

        networkService.createSslCertificate(certificate);

        return showSslCertificates();
    }

    @ModelAttribute(value = "networkNavbarItems")
    public List<NetworkNavbarItem> getNetworkNavbarItems() {
        return Arrays.asList(NetworkNavbarItem.values());
    }

    @Override
    public NavbarItem getSelectedNavbarItem() {
        return NavbarItem.NETWORK;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return showSslCertificates();
    }

    @RequestMapping(value = "/dns", method = RequestMethod.GET)
    public ModelAndView showDnsRecords() {
        final ModelAndView mv = new ModelAndView("network/showDnsRecords");
        setCurrentNavbarItem(mv, NetworkNavbarItem.DNS_RECORDS);

        final List<DnsRecord> dnsRecords = networkService.getActiveDnsRecords();
        mv.addObject(VIEW_VARIABLE_DNS_RECORDS, dnsRecords);

        return mv;
    }

    @RequestMapping(value = "/certs", method = RequestMethod.GET)
    public ModelAndView showSslCertificates() {
        final ModelAndView mv = new ModelAndView("network/showCertificates");
        setCurrentNavbarItem(mv, NetworkNavbarItem.SSL_CERTIFICATES);

        final List<SslCertificate> sslCertificates = networkService.getActiveCertificates();
        mv.addObject(VIEW_VARIABLE_SSL_CERTIFICATES, sslCertificates);

        return mv;
    }

    @RequestMapping(value = "/dns/new", method = RequestMethod.GET)
    public ModelAndView showNewDnsRecord() {
        final ModelAndView mv = new ModelAndView("network/newDnsRecord");
        setCurrentNavbarItem(mv, NetworkNavbarItem.SSL_CERTIFICATES);

        // Load all of the existing Domains
        final List<Domain> domains = networkService.getActiveDomains();
        mv.addObject(VIEW_VARIABLE_DOMAINS, domains);

        return mv;
    }

    @RequestMapping(value = "/cert/new", method = RequestMethod.GET)
    public ModelAndView showNewSslCertificate() {
        final ModelAndView mv = new ModelAndView("network/newCertificate");
        setCurrentNavbarItem(mv, NetworkNavbarItem.SSL_CERTIFICATES);

        // Load all of the existing Domains
        final List<Domain> domains = networkService.getActiveDomains();
        mv.addObject(VIEW_VARIABLE_DOMAINS, domains);

        return mv;
    }

    void setCurrentNavbarItem(final ModelAndView mv, final NetworkNavbarItem navbarItem) {
        mv.addObject(VIEW_VARIABLE_CURRENT_NAVBAR_ITEM, navbarItem);
    }

}
