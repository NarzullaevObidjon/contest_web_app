package uz.pdp.contest_web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebFilter(filterName = "SignUpFilter", urlPatterns = "/auth/signup-final")
public class SignUpFilter extends HttpFilter {
    public static List<String> confirmedEmails = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        A valid username should start with an alphabet so, [A-Za-z].
//All other characters can be alphabets, numbers or an underscore so, [A-Za-z0-9_].
//Since length constraint was given as 8-30 and we had already fixed the first character, so we give {7,29}.
//We use ^ and $ to specify the beginning and end of matching.
        if(request.getMethod().equals("POST")){
            String usernameRegex = "^[A-Za-z][A-Za-z0-9_]{7,29}$";
//        Minimum eight characters, at least one letter and one number:
            String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirm-password");
            if (confirmedEmails.contains(email)) {
                if (!username.matches(usernameRegex)) {
                    request.setAttribute("usernameError","usernameError"  );
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/signupfinal.jsp");
                    dispatcher.forward(request,response);
                }
                else if (!password.matches(passwordRegex)){
                    request.setAttribute("passwordError","passwordError"  );
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/signupfinal.jsp");
                    dispatcher.forward(request,response);
                }
                else if (!password.equals(confirmPassword)) {
                    request.setAttribute("confirmPasswordError","confirmPasswordError"  );
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/signupfinal.jsp");
                    dispatcher.forward(request,response);
                }else {
                    chain.doFilter(request,response);
                }

            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendError(400,"Try again");

            }
        }


    }
}
