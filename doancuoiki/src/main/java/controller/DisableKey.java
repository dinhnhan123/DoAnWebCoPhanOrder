package controller;

import Dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisableKey", value = "/disablekey")
public class DisableKey extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();
        dao.disableKey(Integer.parseInt(request.getParameter("id")));
    }
}
