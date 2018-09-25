package net.htmlonline.service;

import net.htmlonline.domain.User;

import java.sql.SQLException;

public interface UserService {
    public int register(User user) throws SQLException;
}
