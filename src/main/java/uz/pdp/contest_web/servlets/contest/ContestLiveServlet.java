package uz.pdp.contest_web.servlets.contest;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uz.pdp.contest_web.daos.*;
import uz.pdp.contest_web.domains.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

@WebServlet(name = "ContestLiveServlet", urlPatterns = "/contest-live")
public class ContestLiveServlet extends HttpServlet {

    public static Test test;
    ConcurrentHashMap<String, List<ResultQuestion>> list = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, Long> started = new ConcurrentHashMap<>();
    @Override
    public void init() {
        try {
            test = TestDAO.get().getLiveTest();
        } catch (Exception e) {}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (test == null)
            init();
        if (test == null) {
            response.sendRedirect("/");
            return;
        }
        request.setAttribute("question", test.getQuestions().get(0));
        request.setAttribute("curr", 1);
        request.setAttribute("prev", 0);
        request.setAttribute("next", 2);
        request.setAttribute("count",test.getQuestions().size());
        started.put(username, System.currentTimeMillis());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/test/contest_live.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String  username = (String) request.getSession().getAttribute("username");
        if (test.getInterval()<System.currentTimeMillis()-started.get(username)){
            request.setAttribute("error", "Time is over");
            list.remove(username);
            started.remove(username);
            return;
        }
        Integer curr;
        try {
            curr = Integer.valueOf(request.getParameter("curr"));
        } catch (NumberFormatException e) {
            curr = 1;
        }
        byte answer = -1;
        try {
            answer = Byte.parseByte(request.getParameter("answer"));
        } catch (NumberFormatException e) {}
        list.computeIfAbsent(username,
                k -> new ArrayList<>()).add(ResultQuestion.builder()
                .user(UserDAO.get().getByUsername(username))
                .given(answer)
                .correct(answer==test.getQuestions().get(curr-1).getCorrectAnswerIndex())
                .question(test.getQuestions().get(curr-1))
                .build());

        if(curr==test.getQuestions().size()){
            List<ResultQuestion> resultQuestions = list.get(username);
            int points=0;
            ResultQuestionDAO resultQuestionDAO = ResultQuestionDAO.get();
            for (ResultQuestion resultQuestion : resultQuestions) {
                points=points+(resultQuestion.getCorrect()?1:0);
                resultQuestionDAO.save(resultQuestion);
            }
            ResultUserDAO resultUserDAO = ResultUserDAO.get();
            resultUserDAO.save(ResultUser.builder()
                            .interval(System.currentTimeMillis()-started.get(username))
                            .points((long) points)
                            .test(test)
                            .user(UserDAO.get().getByUsername(username))
                    .build());
            list.remove(username);
            request.setAttribute("test",test);
            request.setAttribute("points",points);
            request.setAttribute("interval",getPrettyInterval(System.currentTimeMillis()-started.get(username)));
            request.getRequestDispatcher("/views/test/test_finish.jsp").forward(request,response);
            started.remove(username);
            return;
        }
        
        Long next = Long.valueOf(request.getParameter("next"));
        String prev = request.getParameter("prev");
        if(next!=null){
            request.setAttribute("curr", curr+1);
            request.setAttribute("prev", curr);
            request.setAttribute("next", curr+2);
            curr++;
        } else if (prev != null) {
            request.setAttribute("curr", curr-1);
            request.setAttribute("prev", curr-2);
            request.setAttribute("next", curr);
            curr--;
        }
        request.setAttribute("question", test.getQuestions().get(curr.intValue()-1));
        request.setAttribute("count",test.getQuestions().size());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/test/contest_live.jsp");
        dispatcher.forward(request, response);
    }

    public String getPrettyInterval(long interval){
        long m=interval /1000/60;
        long sec = interval / 1000 % 60;
        return m+" minutes, "+sec+" seconds";
    }
}
