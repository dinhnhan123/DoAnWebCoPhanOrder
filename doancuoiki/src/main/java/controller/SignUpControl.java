package controller;

import Dao.Dao;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignUpControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        if(!pass.equals(re_pass)){
            request.setAttribute("messSignUp","Mật khẩu bạn vừa nhập lại không khớp, vui lòng kiểm tra lại");
            request.getRequestDispatcher("Login.jsp").forward(request,response);

        }else{
             Dao dao = new Dao();
            Account a = dao.CheckUserExist(user);
             if(a == null){
              dao.signUp(user,pass,fullname,email,phone,address,note);
              Account account = dao.login(user,pass);
                 HttpSession session = request.getSession();
                 session.setAttribute("acc",account);
                 session.setMaxInactiveInterval(1000);
              response.sendRedirect("homeControl");

             }else {
              request.setAttribute("messSignUp","Username đã tồn tại");
              request.getRequestDispatcher("Login.jsp").forward(request,response);

             }
        }

    }
}
