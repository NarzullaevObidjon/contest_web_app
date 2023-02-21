package uz.pdp.contest_web.servlets.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.User;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/auth/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/auth/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String next = request.getParameter("next");
        String password = request.getParameter("password");
        UserDAO userDAO = UserDAO.get();

        User user = userDAO.getByUsername(username);

        if (user == null || !password.equals(user.getPassword())) {
            response.sendRedirect("/auth/login");
        }else if(next!=null){
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            cookie.setMaxAge(5 * 60 * 60);
            response.addCookie(cookie);
            response.sendRedirect(next);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("role",user.getRole());
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            cookie.setMaxAge(5 * 60 * 60);
            response.addCookie(cookie);
            response.sendRedirect("/");
        }

    }
}
