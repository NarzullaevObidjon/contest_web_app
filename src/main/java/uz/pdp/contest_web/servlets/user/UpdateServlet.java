package uz.pdp.contest_web.servlets.user;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uz.pdp.contest_web.daos.DocumentDAO;
import uz.pdp.contest_web.daos.UserDAO;
import uz.pdp.contest_web.domains.Document;
import uz.pdp.contest_web.domains.User;
import uz.pdp.contest_web.utils.StringUtils;

import java.io.IOException;
import java.nio.file.Path;

@WebServlet(name = "UpdateServlet", value = "/profile/update/*")
//@MultipartConfig(location = "C:/Users/Muhammadjon/Desktop/Новая папка (3)/contest_web_app/src/main/webapp/resources/images/")
public class UpdateServlet extends HttpServlet {
//    private static final Path rootPath = Path.of("C:/Users/Muhammadjon/Desktop/Новая папка (3)/contest_web_app/src/main/webapp/resources/images/");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = UserDAO.get();
        String username = request.getPathInfo().substring(1);
        User byUsername = userDAO.getByUsername(username);
        if (byUsername == null) {
            response.sendRedirect("/main");
        }
        request.setAttribute("user", byUsername);
        request.getRequestDispatcher("/resources/pages/profile/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = UserDAO.get();
        String substring = request.getPathInfo().substring(1);
        User byUsername = userDAO.getByUsername(substring);

        if (byUsername == null) {
            response.sendRedirect("/main");
        }
        String username1 = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String country = request.getParameter("country");
        byUsername.setUsername(username1);
        byUsername.setFirstName(firstName);
        byUsername.setLastName(lastName);
        byUsername.setCountry(country);
        userDAO.update(byUsername);
        response.sendRedirect("/profile/" + substring);
    }


    private Document saveCover(Part part) {
        try {
            DocumentDAO documentDAO = DocumentDAO.get();
            String generateUniqueName = StringUtils.generateUniqueName(part);
//            Path coverPath = rootPath.resolve(generateUniqueName);
            //            byte[] bytes = ImageUtils.resizeForCover(part.getInputStream(), coverPath);
            String originalName = part.getSubmittedFileName();
            String extension = StringUtils.getFileExtension(originalName);
            String mimeType = part.getContentType();
            Document document = Document.builder()
                    .generatedFileName(generateUniqueName)
                    .originalFileName(originalName)
                    .fileSize(part.getSize())
                    .mimeType(mimeType)
//                    .filePath(rootPath.resolve(generateUniqueName).toString())
                    .extension(extension)
                    .build();
            document = documentDAO.save(document);
//            ImageUtils.resizeForCover(part.getInputStream(), rootPath.resolve(generateUniqueName));
            return document;
        } catch (Exception e) {
            return null;
        }
    }
}
