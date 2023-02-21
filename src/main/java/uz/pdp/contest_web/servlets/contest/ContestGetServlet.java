package uz.pdp.contest_web.servlets.contest;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uz.pdp.contest_web.daos.QuestionDAO;
import uz.pdp.contest_web.daos.TestDAO;
import uz.pdp.contest_web.domains.Question;
import uz.pdp.contest_web.domains.Test;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContestGetServlet", urlPatterns = "/contest/*")
public class ContestGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getPathInfo()!=null){
            Long contestId = Long.valueOf(request.getPathInfo().substring(1));
            TestDAO testDAO = TestDAO.get();
            QuestionDAO questionDAO = QuestionDAO.get();
            Test test = testDAO.findById(contestId);
            List<Question> questions = questionDAO.getByTestId(contestId);
            request.setAttribute("test",test);
            request.setAttribute("questions",questions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/test/contest.jsp");
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
