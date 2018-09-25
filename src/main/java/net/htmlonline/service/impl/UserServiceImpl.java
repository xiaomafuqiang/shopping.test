package net.htmlonline.service.impl;

import net.htmlonline.dao.impl.UserDaoImpl;
import net.htmlonline.domain.User;
import net.htmlonline.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private static UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public int register(User user) throws SQLException {
        return userDao.register(user);
    }
}
