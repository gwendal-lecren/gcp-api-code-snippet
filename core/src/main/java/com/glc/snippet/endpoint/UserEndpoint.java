package com.glc.snippet.endpoint;

import com.glc.snippet.model.AppUser;
import com.google.api.server.spi.ServiceException;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.ApiClass;
import com.google.api.server.spi.config.ApiMethod;
import lombok.extern.slf4j.Slf4j;

import static com.google.api.server.spi.config.ApiMethod.HttpMethod.GET;

@ApiClass(resource = "users")
@Slf4j
public class UserEndpoint extends AuthenticatedEndpoint {

    @ApiMethod(path = "me", httpMethod = GET)
    public AppUser getCurrentUser(User user) throws ServiceException {
        return wrap(user, appUser -> AppUser.create(user));
    }

}
