package com.glc.snippet.endpoint;

import com.google.api.server.spi.ServiceException;
import com.google.api.server.spi.config.Api;

@Api(
        name = "bulkexporter",
        version = "v1",
        title = "Bulk Exporter API"
)
public abstract class NonAuthenticatedEndpoint {

    protected interface ApiTask<T> {
        T apply() throws ServiceException;
    }

    protected <T> T wrap(ApiTask<T> action) throws ServiceException {
        return action.apply();
    }

}
