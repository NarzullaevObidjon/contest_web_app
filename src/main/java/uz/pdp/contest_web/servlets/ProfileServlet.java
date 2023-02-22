package uz.pdp.contest_web.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.ResultUser;
import uz.pdp.contest_web.domains.User;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile/*")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = UserDAO.get();
        String username = request.getPathInfo().substring(1);
        User byUsername = userDAO.getByUsername(username);
        if(byUsername==null){
            response.sendRedirect("/main");
        }
        request.setAttribute("user", byUsername);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/resources/pages/profile/profile.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
