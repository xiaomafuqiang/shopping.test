package net.htmlonline.dao;

import net.htmlonline.domain.User;

import java.sql.SQLException;

public interface UserDao {
    public int register(User user) throws SQLException;
}
