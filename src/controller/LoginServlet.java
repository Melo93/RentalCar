package controller;

import dao.impl.UtenteDAOImpl;
import model.bean.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    UtenteDAOImpl utenteDAO;
    @Override
    public void init() throws ServletException {
       utenteDAO = new UtenteDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        Utente utente;
        System.out.println(request.getParameter("Username") + " " + request.getParameter("Password"));
        utente=utenteDAO.getUserByUsernameAndPassword(request.getParameter("username"), request.getParameter("password"));
        if(utente==null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            request.getSession().setAttribute("utente",utente);
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("/index");
        }

        return;
    }

}
