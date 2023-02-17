package uz.pdp.contest_web.servlets;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uz.pdp.contest_web.daos.DocumentDAO;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.Document;
import uz.pdp.contest_web.domains.User;

@WebServlet(name = "MainServlet", value = "/main")
public class MainServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDAO userDAO = UserDAO.get();
        DocumentDAO documentDAO = DocumentDAO.get();
        documentDAO.save(Document.builder()
                .build());
        User user = userDAO.save(User.builder()
                .email("obid@gmail.com")
                .username("obid0444")
                .firstName("Obid")
                .password("0444")
                .country("Uzbekistan")
                .build());
        response.getWriter().write(user.toString());
    }

    public void destroy() {
    }
}