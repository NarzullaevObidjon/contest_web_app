package uz.pdp.contest_web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import uz.pdp.contest_web.daos.UserDAO;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "MainServlet", value = "/")
public class MainServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        Object role = session.getAttribute("role");
        request.setAttribute("username", username);
        if (role!=null && role.equals("ADMIN")) {
            request.getRequestDispatcher("/resources/pages/admin/main.jsp").forward(request, response);
        } else
            request.getRequestDispatcher("/views/main.jsp").forward(request, response);
    }

    public void destroy() {
    }
}