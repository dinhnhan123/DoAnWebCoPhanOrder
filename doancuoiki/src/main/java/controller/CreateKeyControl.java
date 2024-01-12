package controller;

import Dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "CreateKey", value = "/createkey")
public class CreateKeyControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();
        dao.createKey(Integer.parseInt(request.getParameter("id")));
    }
}
