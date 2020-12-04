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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    @Autowired
    private ProductService productService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取并搜索前台传来的产品
        int proId = Integer.parseInt(request.getParameter("proId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = productService.getProductById(proId);

        //尝试获得购物车map，空创建，有则下一步
        HttpSession session = request.getSession();
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        if (cart==null){
            cart = new HashMap<Product, Integer>();
            cart.put(product, quantity);
            session.setAttribute("cart", cart);
        }else{
            //判断购物车map中是否有对应的产品，法1：遍历
            /*boolean flag = false;       //假设无相同物品
            for (Map.Entry<Product, Integer> entry : cart.entrySet()){
                if (entry.getKey().getProId() == product.getProId()){
                    //有相同产品，将quantity加上value
                    cart.put(entry.getKey(), entry.getValue()+quantity);
                    flag = true;
                    break;
                }
            }

            //flase则没有相同物品，加入即可
            if (!flag){
                cart.put(product, quantity);
            }*/

            //法2：修改bean的hashCode及equals方法，判断是否包含相同key
            if(cart.containsKey(product)){
                cart.put(product, cart.get(product)+quantity);
            }else{
                cart.put(product, quantity);
            }
        }

        //后台运算总价格
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()){
            totalPrice += entry.getKey().getShopPrice()*cart.get(entry.getKey());
        }
        session.setAttribute("totalPrice", totalPrice);

        response.sendRedirect("/html/cart.jsp");        //重定向和转发请求对图片地址的处理不同，前者不加项目路径会自动将网页所在路径加到图片地址前
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
