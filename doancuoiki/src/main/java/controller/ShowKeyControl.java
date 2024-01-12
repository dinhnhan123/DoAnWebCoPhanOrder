package controller;

import Dao.Dao;
import model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ShowKey", value = "/showkey")
public class ShowKeyControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("acc") != null){
            Dao dao = new Dao();
            Account account = dao.getUserByUserName(request.getParameter("user"));
            request.setAttribute("acc", account);
            request.getRequestDispatcher("ShowKey.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("Login.jsp");
        }
    }
}
