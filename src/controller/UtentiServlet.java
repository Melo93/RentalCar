package controller;

import dao.UtenteDAO;
import dao.impl.UtenteDAOImpl;
import model.bean.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class UtentiServlet extends HttpServlet {
    private UtenteDAO utenteDAO;

    public void init() {
        utenteDAO = new UtenteDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("prova");
        String action = request.getServletPath();
        List<Utente> utenti= utenteDAO.getAllUser();
        utenti.forEach(s->System.out.println(s.toString()));
        request.setAttribute("ListaUtenti", utenti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
