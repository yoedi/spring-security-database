package com.authyd.springsecuritydb.model.builder;

import com.authyd.springsecuritydb.model.User;

public class UserBuilder {

    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public UserBuilder setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public UserBuilder setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public UserBuilder setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public User build() {
        return new User(
                this.username,
                this.password,
                this.enabled,
                this.accountNonExpired,
                this.accountNonLocked,
                this.credentialsNonExpired
        );
    }
}
