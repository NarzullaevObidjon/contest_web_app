package uz.pdp.contest_web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.contest_web.daos.UserDAO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@WebFilter(filterName = "UserBlackEditValidationFilter", urlPatterns = "/admin/usersBlocked/edit")
public class UserBlackEditValidationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        var req = (HttpServletRequest) request;
        var res = (HttpServletResponse) response;
        String userId = req.getParameter("userId");
        String userRole = req.getParameter("userRole");
        if(Objects.isNull(userRole)) {
            if (req.getMethod().equalsIgnoreCase("get")) {
                if (userId == null || userId.isBlank() || !userId.matches("[0-9]+")) {
                    request.setAttribute("user_error", "Invalid parameters");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/resources/pages/admin/usersBlackList.jsp");
                    dispatcher.forward(req, res);
                } else chain.doFilter(req, res);
            } else
                chain.doFilter(req, res);
        }else {
            String userStatus = request.getParameter("userStatus");
            String blockCause = request.getParameter("blockCause");
            String blockTill = request.getParameter("blockTill");
            System.out.println("blockCause = " + blockCause);
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (userStatus == null) {
                    if (blockTill == null && blockCause == null) {
                        chain.doFilter(req, res);
                    } else {
                        UserDAO userDAO = UserDAO.get();
                        request.setAttribute("user", userDAO.findById(Long.valueOf(userId)));
                        request.setAttribute("user_error", "Something wrong. Try again");
                        RequestDispatcher dispatcher = req.getRequestDispatcher("/resources/pages/admin/editBlackUser.jsp");
                        dispatcher.forward(req, res);
                    }
                } else if (userStatus.equals("on")) {
                    if (blockTill.isBlank() || blockCause.isBlank() || LocalDateTime.parse(blockTill).isBefore(LocalDateTime.now(ZoneId.of("Asia/Tashkent")))) {
                        UserDAO userDAO = UserDAO.get();
                        request.setAttribute("user", userDAO.findById(Long.valueOf(userId)));
                        request.setAttribute("user_error", "Something wrong. Try again");
                        RequestDispatcher dispatcher = req.getRequestDispatcher("/resources/pages/admin/editBlackUser.jsp");
                        dispatcher.forward(req, res);
                    }else chain.doFilter(req, res);
                }
            } else chain.doFilter(req, res);
        }
    }
}
