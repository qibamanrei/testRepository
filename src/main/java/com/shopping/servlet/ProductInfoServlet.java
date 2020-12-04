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

@WebServlet("/ProductInfoServlet")
public class ProductInfoServlet extends HttpServlet {
    @Autowired
    private  ProductService productService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取前台数据
        int proId = Integer.parseInt(request.getParameter("productId"));

        //2、调用service获得product信息
        Product product = productService.getProductById(proId);
        //3、将product装入request
        request.setAttribute("product", product);
        //4、转发request到详情页面
        request.getRequestDispatcher("/html/productinfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
