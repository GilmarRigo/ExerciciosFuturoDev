package br.com.futurodev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<h1>Cálculo de Média</h1>");

        String aluno = req.getParameter("aluno");
        String disciplina = req.getParameter("disciplina");
        String nota1 = req.getParameter("nota1");
        String nota2 = req.getParameter("nota2");
        String nota3 = req.getParameter("nota3");
        String nota4 = req.getParameter("nota4");

        /*
        writer.println("<ul>");
        writer.println("<li>Aluno: " + aluno + "</li>");
        writer.println("<li>Disciplina: " + disciplina + "</li>");
        writer.println("<li>Nota 1: " + nota1 + "</li>");
        writer.println("<li>Nota 2: " + nota2 + "</li>");
        writer.println("<li>Nota 3: " + nota3 + "</li>");
        writer.println("<li>Nota 4: " + nota4 + "</li>");
        */

        double media = ((Double.parseDouble(nota1)) + (Double.parseDouble(nota2)) +
                (Double.parseDouble(nota3)) + (Double.parseDouble(nota4)))/4;

        writer.println("<h3>Olá aluno(a) " + aluno + " suas notas são: nota 1 =  " + Double.parseDouble(nota1) +
                        ", nota 2 = " + Double.parseDouble(nota2) + ", nota 3 = " + Double.parseDouble(nota3) + ", nota 4 = " + Double.parseDouble(nota4) +
                        " e sua média na disciplina " + disciplina + " foi " + media + ".</h3>");


    }
}
