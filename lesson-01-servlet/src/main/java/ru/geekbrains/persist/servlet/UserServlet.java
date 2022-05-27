package ru.geekbrains.persist.servlet;

import ru.geekbrains.persist.user.User;
import ru.geekbrains.persist.user.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = new UserRepository();
        userRepository.insert(new User("Иванов И.П.", "директор", 180000));
        userRepository.insert(new User("Петров А.И.", "бухгалтер", 65000));
        userRepository.insert(new User("Маркова Т.Ю", "менеджер по снабжению", 45000));
        userRepository.insert(new User("Петрова В.Ю", "специалист по продажам", 45000));
        userRepository.insert(new User("Попова Ю.К", "секретарь", 25000));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        if (req.getPathInfo() == null) {
            wr.println("<h3> list of all users</h3>");
            wr.println("<table border=1>");
            wr.println("<tr>");
            wr.println("<th>id</th>");
            wr.println("<th>username</th>");
            wr.println("</tr>");

            for (User user : userRepository.findAll()) {
                wr.println("<tr>");
                wr.println("<th align=left>" + user.getId() + "</th>");
                wr.println("<th align=left>" + user.getUsername() + "</th>");
                wr.println("</tr>");
                // TODO добавить создание строк таблицы для каждого из пользователей (продуктов)
            }

            wr.println("</table>");
        }
        if (req.getPathInfo() != null) {
            try {
            User infoUser = userRepository.findById(Long.parseLong(req.getPathInfo().replace("/", "")));
            wr.println("<h3> User information </h3>");
            wr.println("<table border=1>");
            wr.println("<tr><th>id</th>");
            wr.println("<th>username</th>");
            wr.println("<th>post</th>");
            wr.println("<th>salary</th></tr>");
            wr.println("<th align=left>" + infoUser.getId() + "</th>");
            wr.println("<th align=left>" + infoUser.getUsername() + "</th>");
            wr.println("<th align=left>" + infoUser.getPost() + "</th>");
            wr.println("<th align=left>" + infoUser.getSalary() + "</th>");
            wr.println("</tr>");
            wr.println("</table>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
