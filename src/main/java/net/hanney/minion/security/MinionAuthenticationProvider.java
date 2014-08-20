package net.hanney.minion.security;

import net.hanney.minion.service.IdentityService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * {@link org.springframework.security.authentication.AuthenticationProvider} that is used to
 * authenticate users in the Minion system
 *
 * @author justin.hanney
 */
@Service
public class MinionAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    static final Logger LOG = LoggerFactory.getLogger(MinionAuthenticationProvider.class);

    @Autowired
    private IdentityService identityService;

    @Override
    protected void additionalAuthenticationChecks(final UserDetails userDetails,
                                                  final UsernamePasswordAuthenticationToken authToken)
            throws AuthenticationException {
        LOG.info("No additional authentication checks for User: {}", userDetails);
    }

    @Override
    protected UserDetails retrieveUser(final String principal,
                                       final UsernamePasswordAuthenticationToken authToken)
            throws AuthenticationException {
        LOG.debug("Retrieving user: {}", principal);

        if(authToken == null) {
            throw new BadCredentialsException("Authentication Token was not supplied");
        }
        if(authToken.getPrincipal() == null || StringUtils.isBlank(authToken.getPrincipal().toString())) {
            throw new AuthenticationCredentialsNotFoundException("Name was not supplied");
        }
        if(authToken.getCredentials() == null || StringUtils.isBlank(authToken.getCredentials().toString())) {
            throw new AuthenticationCredentialsNotFoundException("Password was not supplied");
        }

        final String email    = authToken.getPrincipal().toString();
        final String password = authToken.getCredentials().toString();

        try {
            return identityService.authenticateUser(email, password);
        } catch (net.hanney.minion.service.AuthenticationException ae) {
            LOG.debug("User was not authenticated: ".concat(email), ae);
            throw new BadCredentialsException("User was not successfully authenticated");
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return true;
    }
}
