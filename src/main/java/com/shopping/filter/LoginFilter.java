package com.shopping.filter;

import com.shopping.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/AddCartServlet", "/DeletCartServlet", "/html/cart.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null){
            ((HttpServletResponse)resp).sendRedirect(request.getContextPath()+"/html/login.jsp?msg=pleaselogin");
        }else
        {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
