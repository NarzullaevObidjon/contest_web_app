package uz.pdp.contest_web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.User;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@WebFilter(filterName = "SecurityFilter", value = "/*")
public class SecurityFilter implements Filter {

    private static final UserDAO authUserDAO = UserDAO.get();

    private static final List<String> WHITE_LIST = List.of(
            "/contests",
            "/contest.*",
            "/auth/signup",
            "/",
            "/admin.*",
            "/auth/login",
            "/auth/logout",
            "/resources.*",
            "/profile.*"
    );

    private static final Predicate<String> isOpen = o -> {
        for (String s : WHITE_LIST) {
            if (o.matches(s)) {
                return true;
            }
        }
        return false;
    };
    private static final Predicate<String> isAdminPages = (uri) -> uri.startsWith("/admin");

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String requestURI = request.getRequestURI();
        if (!isOpen.test(requestURI)) {
            HttpSession session = request.getSession();
            Object username = session.getAttribute("username");
            Object role = session.getAttribute("role");
            if (Objects.isNull(username)) {
                response.sendRedirect("/auth/login?next=" + requestURI);
            }else {
                if (Objects.equals("USER", role) && isAdminPages.test(requestURI)) {
                    response.sendError(403, "Permission denied");
                } else {
                    chain.doFilter(request, response);
                }
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    private boolean checkForRememberMe(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) return true;
        for (Cookie cookie : request.getCookies()) {
            String cookieName = cookie.getName();
            if (cookieName.equals("rememberMe")) {
                User authUser = authUserDAO.findById(Long.valueOf(cookie.getValue()));
                session.setAttribute("role", authUser.getRole());
                session.setAttribute("username", authUser.getUsername());
                return true;
            }
        }
        return false;
    }
}
