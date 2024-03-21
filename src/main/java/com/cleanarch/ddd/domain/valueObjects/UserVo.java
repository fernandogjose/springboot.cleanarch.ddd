package com.cleanarch.ddd.domain.valueObjects;

import java.io.Serial;
import java.io.Serializable;

public class UserVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    private String username;

    private String password;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
