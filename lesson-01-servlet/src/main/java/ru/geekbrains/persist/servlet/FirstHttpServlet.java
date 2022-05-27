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

@WebServlet(urlPatterns = "/first_http_servlet/*")
public class FirstHttpServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = new UserRepository();
        userRepository.insert(new User("Иванов И.П.", "директор", 180000));
        userRepository.insert(new User("Петров А.И.", "бухгалтер", 65000));
        userRepository.insert(new User("Маркова Т.Ю", "менеджер по снабжению", 45000));
        userRepository.insert(new User("Петрова В.Ю", "специалист по продажам", 45000));
        userRepository.insert(new User("Попова Ю.К", "уборщица", 25000));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Username</th>");
        wr.println("</tr>");

        for (User user : userRepository.findAll()) {
            // TODO добавить создание строк таблицы для каждого из пользователей (продуктов)
        }

        wr.println("</table>");
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
//        resp.getWriter().println("<p>servletPath: " + req.getServletPath() + "</p>");
//        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
//        resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");
//        resp.getWriter().println("<p>param1: " + req.getParameter("param1") + "</p>");
//        resp.getWriter().println("<p>param2: " + req.getParameter("param2") + "</p>");
//    }
}
