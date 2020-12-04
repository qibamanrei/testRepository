package com.shopping.servlet;

import com.shopping.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/DeletCartServlet")
public class DeletCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取前台传来的产品id并构造product
        int proId = Integer.parseInt(request.getParameter("proId"));
        Product product = new Product();
        product.setProId(proId);

        //获取cartmap
        HttpSession session = request.getSession();
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        cart.remove(product);

        //更新总价
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()){
            totalPrice += entry.getKey().getShopPrice()*cart.get(entry.getKey());
        }
        session.setAttribute("totalPrice", totalPrice);

        response.sendRedirect("/html/cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
