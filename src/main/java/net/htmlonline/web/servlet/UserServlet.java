package net.htmlonline.web.servlet;

import com.alibaba.fastjson.JSON;
import net.htmlonline.domain.User;
import net.htmlonline.service.impl.UserServiceImpl;
import net.htmlonline.utils.Utils;
import net.htmlonline.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private static UserServiceImpl userService = new UserServiceImpl();

    public String register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = Utils.parseRequestJson(req);

        User user = JSON.parseObject(json, User.class);

        try {
            int register = userService.register(user);
            System.out.println("int register" + register);

            if (register > 0) {
                String result = Utils.result(user, 200);
                System.out.println(result);
                return result;
            } else {
                return "{}";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "{}";
    }
}
