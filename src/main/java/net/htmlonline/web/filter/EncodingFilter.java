package net.htmlonline.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 统一编码
 * @author Administrator
 *
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("EncodingFilter.....");

        //1.强转
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		resp.setContentType("application/json");
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        System.out.println("requestURI :: -> " + requestURI);
        //System.out.println("@@@@@@@@@@@@@@@@@@");
		//2.放行
		chain.doFilter(new MyRequest(request), response);
	}

}

