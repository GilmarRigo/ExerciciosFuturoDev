package br.com.futurodev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class PrimeiroExercicio extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");

        writer.println("<h2>Painel de entrada.</h2>");
        writer.println("<h3>");

        if(usuario.equals("admin") && (senha.equals("password"))){
            writer.println("Bem-vindo usuário admin!");
        } else {
            writer.println("Login e/ou senha inválidos!");
        }

    }
}
