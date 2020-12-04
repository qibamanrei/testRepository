package com.shopping.servlet;

import com.shopping.bean.Product;
import com.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductShowServlet")
public class ProductShowServlet extends HttpServlet {
    @Autowired
    private ProductService productService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        List<Product> hostList = productService.selectProductListByState(1);
        List<Product> optimizationList = productService.selectProductListByState(2);
        //请求中放入两个list
        request.setAttribute("hotList", hostList);
        request.setAttribute("optimizationList", optimizationList);

        request.getRequestDispatcher("/html/productshow.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
