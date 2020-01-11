package com.glc.snippet.endpoint;

import com.google.api.server.spi.ServiceException;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.AuthLevel;
import com.google.api.server.spi.response.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ResourceBundle;

import static com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID;

@Api(
        name = "gcpapi",
        version = "v1",
        title = "Google Cloud Endpoints API",
        description = "A simple GCE API",
        authLevel = AuthLevel.REQUIRED,
        clientIds = {
                API_EXPLORER_CLIENT_ID
        }
)
@Slf4j
public abstract class AuthenticatedEndpoint {

    private final ResourceBundle ERRORS = ResourceBundle.getBundle("messages.errors");

    /**
     * Check the request comes from an authenticated user
     *
     * @param user
     * @throws UnauthorizedException
     */
    private void validateUser(User user) throws UnauthorizedException {
        if (user == null || StringUtils.isBlank(user.getEmail())) {
            log.error(ERRORS.getString("user.notloggedin.error"));
            throw new UnauthorizedException(
                    ERRORS.getString("user.notloggedin.error"),
                    ERRORS.getString("user.notloggedin.error.reason")
            );
        }
    }

    protected interface ApiTask<T> {
        T apply(User user) throws ServiceException;
    }

    protected <T> T wrap(User user, ApiTask<T> action) throws ServiceException {
        validateUser(user);
        return action.apply(user);
    }

}
