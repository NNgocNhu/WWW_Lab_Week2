package vn.edu.iuh.fit.www_lab_week2.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.www_lab_week2.frontend.model.ProductModel;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.frontend.model.EmployeeModel;
import java.io.IOException;


@WebServlet("/controls")
public class ServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if (actionObject != null) {
                String action = actionObject.toString();
                if (action.equals("insertEmp")) {
                    EmployeeModel empModel = new EmployeeModel();
                    empModel.insertEmp(req, resp);
                }  else if (action.equals("insert_products")) {
                    ProductModel pm = new ProductModel();
                    pm.insertProduct(req, resp);
                }

            } else {
                resp.sendRedirect("products.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actionObject = req.getParameter("action");
            if (actionObject != null) {
                String action = actionObject.toString();
                if (action.equals("delete_product")) {
                    ProductModel pm = new ProductModel();
                    pm.deleteProduct(req, resp);
                }
            } else {
                resp.sendRedirect("test.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
