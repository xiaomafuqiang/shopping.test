package net.htmlonline.server;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/server")
public class Servers extends BaseServlet {
    public String add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("string name...");
        return null;
    }
}