package ru.geekbrains.ProductApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        this.productRepository.insert(new Product("Banana"));
        this.productRepository.insert(new Product("AnotherBanana"));
        this.productRepository.insert(new Product("Apple"));
        this.productRepository.insert(new Product("Orange"));
        this.productRepository.insert(new Product("Juice"));
        this.productRepository.insert(new Product("Water"));
        this.productRepository.insert(new Product("Something"));
        this.productRepository.insert(new Product("Spam"));
        this.productRepository.insert(new Product("Eggs"));
        this.productRepository.insert(new Product("Coke"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Username</th>");
        wr.println("</tr>");

        if (req.getQueryString() == null) {
            for(Product product : productRepository.findAll()) {
                wr.println("<tr>");
                wr.println("<td><a href='?id=" + product.getId() +"'>" + product.getId() +"</a></td>");
                wr.println("<td>" + product.getName() + "</td>" );
                wr.println("</tr>");
            }
        }

        if(!req.getParameter("id").equals(null)) {
            wr.println("<tr>");
            wr.println("<td>" + req.getParameter("id") +"</td>");
            wr.println("<td>" + productRepository.findById(Long.parseLong(req.getParameter("id"))).getName() + "</td>");
            wr.println("</tr>");
        }

        wr.println("</table>");
    }

}
