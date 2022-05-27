package ru.geekbrains.persist.servlet;

import ru.geekbrains.persist.product.Product;
import ru.geekbrains.persist.product.ProductRepository;
import ru.geekbrains.persist.user.User;
import ru.geekbrains.persist.user.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")

public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        productRepository.insert(new Product ("Кофе в зернах Lavazza Qualita oro 1 кг", 1570));
        productRepository.insert(new Product ("Кофе в зернах Lavazza Qualita oro 1 кг", 1295));
        productRepository.insert(new Product ( "Кофе EGOISTE Noir в зернаx 1000г.", 1399));
        productRepository.insert(new Product ( "Кофе в капсулах Nescafe Dolce Gusto cappuccino 16 капсул ", 1132));
        productRepository.insert(new Product ( "Кофе BUSHIDO Original сублимированный 100г.", 642));
        productRepository.insert(new Product ( "Кофе BUSHIDO Original сублимированный 100г.", 449));
        productRepository.insert(new Product ( "Кофе в зернах Ambassador nero espresso roast 1000 г", 910));
        productRepository.insert(new Product ( "Кофе Jacobs монарх Intense растворимый 500 г", 939));
        productRepository.insert(new Product ( "Кофе растворимый Nescafe gold пакет 220 г", 465));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        wr.println("<h3>List of all product</h3>");
        wr.println("<table border=1>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Title</th>");
        wr.println("<th>Cost</th>");
        wr.println("</tr>");

        for (Product product : productRepository.findAll()) {
            // TODO добавить создание строк таблицы для каждого из пользователей (продуктов)
            wr.println("<tr>");
            wr.println("<th align=left>" + product.getId()+ "</th>");
            wr.println("<th align=left>"  + product.getTitle()+ "</th>");
            wr.println("<th align=left>"  + product.getCost()+ "</th>");
            wr.println("</tr>");
        }

        wr.println("</table>");
    }
}
