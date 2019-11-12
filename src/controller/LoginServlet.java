package controller;

import dao.impl.PrenotazioneDAO;
import dao.impl.TipologiaDAO;
import dao.impl.UtenteDAO;
import dao.impl.VeicoliDAO;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    UtenteDAO utenteDAO;
    VeicoliDAO veicoliDAO;
    PrenotazioneDAO prenotazioneDAO;
    TipologiaDAO tipologiaDAO;

    @Override
    public void init() throws ServletException {
       utenteDAO = new UtenteDAO();
       veicoliDAO = new VeicoliDAO();
       prenotazioneDAO= new PrenotazioneDAO();
       tipologiaDAO= new TipologiaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Utente utente;
        List<Veicoli> veicoli;
        List<Prenotazioni> prenotazioniInAttesa;
        List<Categoria> categorieVeicoli;
        List<Prenotazioni> storicoPrenotazioni;

        prenotazioniInAttesa=prenotazioneDAO.getBookingInPending();
        storicoPrenotazioni=prenotazioneDAO.getBookingHistory();
        utente=utenteDAO.getUserByUsernameAndPassword(request.getParameter("Username"), request.getParameter("Password"));
        veicoli= veicoliDAO.getAllVeicles();
        categorieVeicoli=tipologiaDAO.getAllType();

        if(utente==null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            request.getSession().setAttribute("prenotazioniInAttesa", prenotazioniInAttesa);
            request.getSession().setAttribute("utente",utente);
            request.getSession().setAttribute("veicoli", veicoli);
            request.getSession().setAttribute("categorieVeicoli", categorieVeicoli);
            request.getSession().setAttribute("storicoPrenotazioni",storicoPrenotazioni);
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("index.jsp");
        }
        return;
    }

}
