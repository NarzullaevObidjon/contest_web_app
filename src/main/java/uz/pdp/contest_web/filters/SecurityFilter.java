package uz.pdp.contest_web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

//@WebFilter(filterName = "SecurityFilter", urlPatterns = "/*")
public class SecurityFilter implements Filter {

    List<String> BLACK_LIST = List.of(
            "/profile/*",
            "/contest-live/*"
    );

    private Predicate<String> isBlock = uri ->{
        for (String s : BLACK_LIST) {
            if(s.matches(uri)){
                return true;
            }
        }
        return false;
    };
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String requestURI = request.getRequestURI();
        if(!isBlock.test(requestURI)){
            chain.doFilter(request,response);
        }else {
            Cookie[] cookies = Objects.requireNonNullElse(request.getCookies(), new Cookie[]{});
            Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("sessionID"))
                    .findFirst()
                    .ifPresentOrElse((cookie -> {
                        try {
                            chain.doFilter(request, response);
                        } catch (IOException | ServletException e) {
                            throw new RuntimeException(e);
                        }
                    }), () -> {
                        try {
                            response.sendRedirect("/auth/login?next=" + requestURI);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}
