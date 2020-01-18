package com.glc.snippet.model;

import com.google.api.server.spi.auth.common.User;
import com.google.common.annotations.VisibleForTesting;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AppUser extends GenericEntity {

    @Getter
    private String email;

    @VisibleForTesting
    AppUser(String id, String email) {
        super(id);
        this.email = email;
    }

    public static AppUser create(User user) {
        return new AppUser(user.getId(), user.getEmail());
    }

}
