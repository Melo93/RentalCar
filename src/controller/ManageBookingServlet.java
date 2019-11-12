package controller;

import dao.impl.PrenotazioneDAO;
import model.Prenotazioni;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/booking")
public class ManageBookingServlet extends HttpServlet {
    PrenotazioneDAO prenotazioneDAO;

    @Override
    public void init() throws ServletException {
        prenotazioneDAO=new PrenotazioneDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String state=new String();

       if(req.getParameter("state").equals("Approve"))
           state="APPROVED";
       else
           state="REJECTED";

       prenotazioneDAO.updateBookingState(state,Integer.parseInt(req.getParameter("bookId")));
       List<Prenotazioni> prenotazioniInAttesa = prenotazioneDAO.getBookingInPending();
       List<Prenotazioni> storicoPrenotazioni=prenotazioneDAO.getBookingHistory();
       req.getSession().setAttribute("prenotazioniInAttesa", prenotazioniInAttesa);
       req.getSession().setAttribute("storicoPrenotazioni", storicoPrenotazioni);
       resp.sendRedirect("index.jsp");
    }
}
