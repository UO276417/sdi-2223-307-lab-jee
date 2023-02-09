package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProducts", value = "/products")
public class ServletProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsService service = new ProductsService();
        List<Product> pList = service.getProducts();
        request.setAttribute("storeProducts", pList);
        getServletContext().getRequestDispatcher("/products-view.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
