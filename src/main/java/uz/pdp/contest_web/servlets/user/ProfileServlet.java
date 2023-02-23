package uz.pdp.contest_web.servlets.user;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.ResultUser;
import uz.pdp.contest_web.domains.User;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile/*")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username;
        String username1 = (String)request.getSession().getAttribute("username");
        if(request.getParameter("profile")!=null){
            username=request.getParameter("profile");
        }else {
            username = request.getPathInfo().substring(1);
        }
        UserDAO userDAO = UserDAO.get();
        User byUsername = userDAO.getByUsername(username);
        if(byUsername==null){
            response.sendRedirect("/main");
        }
        request.setAttribute("username1", username1);
        request.setAttribute("user", byUsername);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/resources/pages/profile/profile.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
