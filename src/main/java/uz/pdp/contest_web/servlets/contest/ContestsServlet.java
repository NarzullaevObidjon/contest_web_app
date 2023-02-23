package uz.pdp.contest_web.servlets.contest;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.contest_web.daos.TestDAO;
import uz.pdp.contest_web.domains.Test;

import java.io.IOException;
import java.util.List;

@WebServlet(name="ContestsServlet", urlPatterns = "/contests")
public class ContestsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestDAO testDAO=TestDAO.get();
        List<Test> all = testDAO.findAll();
        req.setAttribute("tests",all);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/resources/pages/contest/contests.jsp");
        requestDispatcher.forward(req,resp);
    }
}
