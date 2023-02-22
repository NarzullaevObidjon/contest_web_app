package uz.pdp.contest_web.servlets.auth;

import jakarta.mail.MessagingException;
import uz.pdp.contest_web.utils.BaseUtil;
import uz.pdp.contest_web.filters.SignUpFilter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.contest_web.utils.EmailSender;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "RegisterServlet", value = "/auth/signup")
public class RegisterServlet extends HttpServlet {

    static ConcurrentHashMap<String, EmailObject> map = new ConcurrentHashMap<>();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/signUp.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code1 = request.getParameter("code");
        String email = request.getParameter("email");
        if (code1 != null) {
            EmailObject emailObject = map.get(email);
            if (emailObject.code.equals(code1) && emailObject.deadline > System.currentTimeMillis()) {
                SignUpFilter.confirmedEmails.add(email);
                request.setAttribute("email", email);
                map.remove(request.getSession().getId());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/signupfinal.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("/auth/signup");
            }
        } else {
            String code = BaseUtil.generateCode();
            map.put(email, new EmailObject(code, System.currentTimeMillis() + 60 * 1000));
            sendEmail(email,"title","body");
            request.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/confirmation.jsp");
            dispatcher.forward(request, response);
        }

    }
    static void sendEmail(String email, String title, String body){
        try {
            EmailSender.sendEmail(email,title,body);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    class EmailObject {
        private String code;
        private Long deadline;

        public EmailObject(String code, Long deadline) {
            this.code = code;
            this.deadline = deadline;
        }
    }
}
