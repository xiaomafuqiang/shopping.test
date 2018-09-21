package net.htmlonline.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service...");
        String methodName = req.getParameter("method");
        String path = null;
        Class clazz = getClass();

        try {
            Method methodFunc = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            if (methodFunc != null) {
                path = (String) methodFunc.invoke(this, req, resp);
            }
            if(path != null) {
                req.getRequestDispatcher(path).forward(req, resp);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
