package net.htmlonline.web.servlet;

import com.alibaba.fastjson.JSON;
import net.htmlonline.domain.User;
import net.htmlonline.utils.Utils;
import net.htmlonline.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {

    public String registerUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("register...");
        System.out.println(req);
        String json = Utils.parseRequestJson(req);
        System.out.println(json);

        User user = JSON.parseObject(json, User.class);
        System.out.println(user);

        return "{}";
    }
}
