package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InicialServlet", urlPatterns = {"/index.html"})
public class InicialServlet extends HttpServlet {

    private List<String> frutas = new ArrayList<>();
    private Comparador c = new Comparador();

    public InicialServlet() {
        frutas = new ArrayList<String>();
        frutas.add("Banana");
        frutas.add("Morango");
        frutas.add("Uva");
        frutas.add("Pêra");
        frutas.add("Abacaxi");
        frutas.add("Mamão");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            String comando = request.getParameter("comando");
            if ("alf".equalsIgnoreCase(comando)) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Exercício 1</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Exercício 1" + "</h1>");
                out.println("<h2>Lista de Frutas" + "</h2>");
                out.println("<h2>" + "</h2>");
                Collections.sort(frutas);
                for (String pessoa : frutas) {
                    out.println("       <li>"
                            + pessoa + "</li>");
                }
                out.println("<p> <a href = '?comando=alf'> Ordem alfabética </a> </p>");
                out.println("<p> <a href = '?comando=pad'> Ordem Aleatória </a> </p>");
                out.println("<p> <a href = '?comando=num'> Ordem por número de letras </a> </p>");
                out.println("   </ul>");
                out.println("</body>");
                out.println("</html>");
            } else if ("pad".equalsIgnoreCase(comando)) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Exercício 1</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Exercício 1" + "</h1>");
                out.println("<h2>Lista de Frutas" + "</h2>");
                Collections.shuffle(frutas);
                for (String pessoa : frutas) {
                    out.println("       <li>"
                            + pessoa + "</li>");
                }
                out.println("<p> <a href = '?comando=alf'> Ordem alfabética </a> </p>");
                out.println("<p> <a href = '?comando=pad'> Ordem Aleatória </a> </p>");
                out.println("<p> <a href = '?comando=num'> Ordem por número de letras </a> </p>");
                out.println("   </ul>");
                out.println("</body>");
                out.println("</html>");
            } else if ("num".equalsIgnoreCase(comando)) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Exercício 1</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Exercício 1" + "</h1>");
                out.println("<h2>Lista de Frutas" + "</h2>");
                Collections.sort(frutas,c);
                for (String pessoa : frutas) {
                    out.println("       <li>"
                            + pessoa + "</li>");
                }
                out.println("<p> <a href = '?comando=alf'> Ordem alfabética </a> </p>");
                out.println("<p> <a href = '?comando=pad'> Ordem Aleatória </a> </p>");
                out.println("<p> <a href = '?comando=num'> Ordem por número de letras </a> </p>");
                out.println("   </ul>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

}
