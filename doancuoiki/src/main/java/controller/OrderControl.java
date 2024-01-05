package controller;

import Dao.Dao;
import model.Item;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "OrderControl", value = "/order")
public class OrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        Dao dao = new Dao();
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String num_phone = request.getParameter("num_phone");
        String note = request.getParameter("note");
        int id_customer = dao.insert_customer(fullname, email, address, num_phone, note);
        // Lấy hoặc tạo mới một phiên
        HttpSession session = request.getSession();

        // Lấy giỏ hàng từ phiên (nếu tồn tại)
        Order order = (Order) session.getAttribute("order");
        // Lưu thông tin giỏ hàng vào cơ sở dữ liệu
        if (order != null) {
            // Lấy danh sách các mặt hàng trong giỏ hàng
            List<Item> items = order.getItems();
            int total_amount = 0;
            int total_product_quantity = 0;
            String order_code = order.generateOrderCode();
            String payment_method = request.getParameter("payment_method");
            for (Item item : items) {
                total_amount+=item.getPrice()*item.getQuantity();
                total_product_quantity+=item.getQuantity();
            }
            int order_id = dao.insert_order(id_customer,total_amount,total_product_quantity,payment_method,address,order_code,fullname);
            for (Item item : items) {
               dao.insert_order_item(order_id,item.getProduct().getId(),item.getQuantity(),(int) (item.getQuantity()*item.getPrice()));
//                PrintWriter out = response.getWriter();
//                out.println("<h1>Hello, " + order_id  + "id:"+item.getProduct().getId()+"quntity"+item.getQuantity()+"price"+ (int) (item.getQuantity()*item.getPrice())+"</h1>");
            }
            PrintWriter out = response.getWriter();
             out.println("<h1>Hello, " + order_id  + "</h1>");
//            PrintWriter out = response.getWriter();
//            out.println("total_amount: " + total_amount + ", total_product_quantity: " + total_product_quantity + "<br>" +order_code);
        } else {
            PrintWriter out = response.getWriter();
            out.println("Cart is empty");
        }
        response.sendRedirect("SendEmail.jsp");
    }

    }








