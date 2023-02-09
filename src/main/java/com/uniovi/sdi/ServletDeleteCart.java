package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletDeleteCart", value = "/ServletDeleteCart")
public class ServletDeleteCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<String, Integer> cart =
                (HashMap<String, Integer>) request.getSession().getAttribute("cart");

        String product = request.getParameter("product");
        if (product != null) {
            DeleteShoppingCart(cart, product);
        }
        request.setAttribute("selectedItems", cart);
        getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void DeleteShoppingCart(Map<String,Integer> cart, String productKey){
        if(cart.get(productKey)== null){

        }else{
            int productCount = (Integer) cart.get(productKey).intValue();
            if(productCount - 1 > 0) {
                cart.put(productKey, Integer.valueOf(productCount - 1));
            }else{
                cart.remove(productKey);
            }
        }
    }
}
