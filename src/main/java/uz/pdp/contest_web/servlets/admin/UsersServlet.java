package uz.pdp.contest_web.servlets.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.daos.DocumentDAO;
import uz.pdp.contest_web.domains.Document;
import uz.pdp.contest_web.domains.User;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "UsersServlet", value = "/admin/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Document document = Document.builder()
//                .extension("aaa1")
//                .filePath("bbb1")
//                .generatedFileName("ccc1")
//                .fileSize(12L)
//                .originalFileName("ddd1")
//                .build();
//        DocumentDAO documentDAO = DocumentDAO.get();
//        documentDAO.save(document);
//        User user = User.builder()
//                .country("Uzbekistan")
//                .email("himmatovnodir@gmail.com")
//                .username("HNOdir")
//                .firstName("Nodir")
//                .lastName("Himmatov")
//                .password("123")
//                .points(12L)
//                .photoDocumentId(document)
//                .build();
//        User user = new User();
//        System.out.println("user.getId() = " + user.getId());
//        user.getBlockCause();
        UserDAO userDAO = UserDAO.get();
//        userDAO.save(user);
        request.setAttribute("users", userDAO.findAll().stream().filter(u->!u.getStatus().equals(User.Status.DELETED)).collect(Collectors.toList()));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/resources/pages/admin/users.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
