package net.htmlonline.dao.impl;

import net.htmlonline.dao.UserDao;
import net.htmlonline.domain.User;
import net.htmlonline.utils.JDBCUtils;
import net.htmlonline.utils.MD5Utils;
import net.htmlonline.utils.UUIDUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public int register(User user) throws SQLException {

        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "insert into user (uid,username, password, email, name, sex, birthday, code) values(?,?,?,?,?,?,?, ?)";

        return runner.update(sql, UUIDUtils.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getSex(), user.getBirthday(), user.getCode());

    }
}
