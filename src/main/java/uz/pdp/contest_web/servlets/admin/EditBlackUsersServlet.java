package uz.pdp.contest_web.servlets.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet(name = "EditBlackUsersServlet", value = "/admin/usersBlocked/edit")
public class EditBlackUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("userId"));
        UserDAO userDAO = UserDAO.get();
        request.setAttribute("user", userDAO.findById(id));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/editBlackUser.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.valueOf(request.getParameter("userId"));
        User.Role userRole = User.Role.valueOf(request.getParameter("userRole"));
        String userStatus = request.getParameter("userStatus");
        String blockCause = request.getParameter("blockCause");
        LocalDateTime blockTill = null;
        if(Objects.isNull(userStatus)){
            userStatus = "NOT_ACTIVE";
        }else{
            userStatus = "BLOCKED";
            blockTill = LocalDateTime.parse(request.getParameter("blockTill"));
        }
        UserDAO userDAO = UserDAO.get();
        User user = userDAO.findById(userId);
        user.setRole(userRole);
        user.setStatus(User.Status.valueOf(userStatus));
        user.setBlockCause(blockCause);
        user.setBlockedTill(blockTill);
        userDAO.update(user);
        request.setAttribute("users", userDAO.findAll().stream().filter(u->!u.getStatus().equals(User.Status.DELETED)).collect(Collectors.toList()));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/users.jsp");
        requestDispatcher.forward(request, response);
    }
}
