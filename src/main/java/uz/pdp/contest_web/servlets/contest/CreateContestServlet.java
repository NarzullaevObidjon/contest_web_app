package uz.pdp.contest_web.servlets.contest;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.Getter;
import uz.pdp.contest_web.daos.QuestionDAO;
import uz.pdp.contest_web.daos.TestDAO;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.Document;
import uz.pdp.contest_web.domains.Question;
import uz.pdp.contest_web.domains.Test;
import uz.pdp.contest_web.domains.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "CreateContestServlet", value = "/admin/createcontest")
public class CreateContestServlet extends HttpServlet {

    ConcurrentHashMap<String, A> inProcess =new ConcurrentHashMap<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        Object role = session.getAttribute("role");
        if(Objects.isNull(username)){
            response.sendRedirect("/auth/login");
        } else  {
            User user = UserDAO.get().getByUsername((String) username);
            if(user.getRole().equals(User.Role.ADMIN)){
                long number = TestDAO.get().getLastTestNumber();
                request.setAttribute("number",number+1);
                request.getRequestDispatcher("/views/test/createContest.jsp").forward(request,response);
            }else {
                response.sendError(403,"Permission Denied");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String title = request.getParameter("title");
        if(title!=null){
            String number = request.getParameter("number");
            String quescount = request.getParameter("quescount");
            String anscount = request.getParameter("anscount");
            String start = request.getParameter("start")+":00";
            String end = request.getParameter("end")+":00";
            String interval = request.getParameter("interval");
            LocalDateTime startTime = LocalDateTime.parse(start, DateTimeFormatter.ISO_DATE_TIME);
            LocalDateTime endTime = LocalDateTime.parse(end, DateTimeFormatter.ISO_DATE_TIME);
            Test test = Test.builder()
                    .creator_id(new User(UserDAO.get().getByUsername(username).getId()))
                    .endTime(endTime)
                    .title(title)
                    .startTime(startTime)
                    .interval(Long.valueOf(interval))
                    .answersCount(Byte.valueOf(anscount))
                    .questionCount(Byte.valueOf(quescount))
                    .number(Long.valueOf(number))
                    .build();
            inProcess.put(username,new A(test));
            request.setAttribute("anscount",anscount);
            request.setAttribute("quescount",quescount);
            request.setAttribute("number",number);
            request.setAttribute("curr",1);
            request.getRequestDispatcher("/views/test/createQuestion.jsp").forward(request,response);
        }else {
            String quescount = request.getParameter("quescount");
            int anscount = Integer.parseInt(request.getParameter("anscount"));
            String curr = request.getParameter("curr");
            String number = request.getParameter("number");
            String question = request.getParameter("question");
            byte correct = Byte.parseByte(request.getParameter("correct"));
            StringJoiner sj = new StringJoiner("\",\"","[\"","\"]");
            for (int i = 1; i < anscount+1; i++) {
                sj.add(request.getParameter("answer-"+i));
            }
            Test test = inProcess.get(username).getTest();
            Question build = Question.builder()
                    .answers(sj.toString())
                    .correctAnswerIndex(correct)
                    .question(question)
                    .question(question)
                    .photoDocumentId(new Document(-1l))
                    .test(test)
                    .build();
            inProcess.get(username).add(build);
            if(curr.equals(quescount)){
                TestDAO.get().save(test);
                List<Question> questions = inProcess.get(username).getQuestions();
                QuestionDAO questionDAO = QuestionDAO.get();
                for (Question question1 : questions) {
                    questionDAO.save(question1);
                }
                inProcess.remove(username);
                response.sendRedirect("/contests");
                return;
            }
            request.setAttribute("anscount",anscount);
            request.setAttribute("quescount",quescount);
            request.setAttribute("number",number);
            request.setAttribute("curr",Integer.parseInt(curr)+1);
            request.getRequestDispatcher("/views/test/createQuestion.jsp").forward(request,response);
        }
    }

    @Getter
    private static class A{
        private Test test;
        private List<Question> questions;

        public A(Test test) {
            this.test = test;
            this.questions = questions = new ArrayList<>();
        }
        void add(Question question){
            this.questions.add(question);
        }
    }

}
