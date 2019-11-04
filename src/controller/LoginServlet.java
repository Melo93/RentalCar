package controller;

import dao.impl.UtenteDAO;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    UtenteDAO utenteDAO;
    @Override
    public void init() throws ServletException {
       utenteDAO = new UtenteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utente utente;
        utente=utenteDAO.getUserByUsernameAndPassword(request.getParameter("Username"), request.getParameter("Password"));
        if(utente==null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            request.getSession().setAttribute("utente",utente);
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("index.jsp");
        }
        return;
    }

}
