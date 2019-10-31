package controller;

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

@WebServlet(name = "UtentiServlet", urlPatterns = {"/UtentiServlet"})
public class UtentiServlet extends HttpServlet {
    private UtenteDAOImpl utenteDAO;

    @Override
    public void init() {
        utenteDAO = new UtenteDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        List<Utente> utenti= utenteDAO.getAllUser();
        request.setAttribute("ListaUtenti", utenti);
        request.getRequestDispatcher("lista.jsp").forward(request,response);
        return;
    }

}
