package uz.pdp.contest_web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.contest_web.daos.UserDAO;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "MainServlet", value = "/")
public class MainServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = String.valueOf(request.getSession().getAttribute("username"));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        request.setAttribute("username", username);
        if (role.equals("ADMIN")) {
            request.getRequestDispatcher("/resources/pages/admin/main.jsp").forward(request, response);
        } else
            request.getRequestDispatcher("/views/main.jsp").forward(request, response);
    }

    public void destroy() {
    }
}