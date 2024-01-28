package org.springboot.repository;

import org.springboot.model.User;

public interface UserRepositoryCustom {
    public User updateEmailByUsername(String username, String email);
}
