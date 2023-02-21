package uz.pdp.contest_web.servlets.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.User;

import java.io.IOException;

@WebServlet(name = "RegisterFinalServlet", value = "/auth/signup-final")
public class RegisterFinalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String country = request.getParameter("country");
        String firstname = request.getParameter("firstname");

        Cookie cookie = new Cookie("username", username);
        cookie.setPath("/");
        cookie.setMaxAge(5  * 60 * 60);
        response.addCookie(cookie);

        UserDAO userDAO = UserDAO.get();
        userDAO.save(User.builder()
                        .status(User.Status.ACTIVE)
                        .email(email)
                        .username(username)
                        .password(password)
                        .country(country)
                        .firstName(firstname)
                .build());
        response.sendRedirect("/auth/login");
    }
}
