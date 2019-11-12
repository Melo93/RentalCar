package controller;

import dao.impl.PrenotazioneDAO;
import dao.impl.UtenteDAO;
import dao.impl.VeicoliDAO;
import model.Prenotazioni;
import model.Utente;
import model.Veicoli;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "RentServlet", urlPatterns = "/rent")
public class RentServlet extends HttpServlet {

    PrenotazioneDAO prenotazioneDAO;
    VeicoliDAO veicoliDAO;
    UtenteDAO utenteDAO;

    @Override
    public void init() throws ServletException {
        prenotazioneDAO=new PrenotazioneDAO();
        veicoliDAO=new VeicoliDAO();
        utenteDAO=new UtenteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("dataInizio")== null && req.getParameter("dataFine")==null){
            Veicoli veicoloSelezionato= veicoliDAO.getVeicleById(Integer.parseInt(req.getParameter("idVeicolo")));
            List<LocalDate> dataInizioPrenotazione=prenotazioneDAO.getBookingStartDateByCarId(Integer.parseInt(req.getParameter("idVeicolo")));
            List<LocalDate> dataFinePrenotazione=prenotazioneDAO.getBookingFinishDateByCarId(Integer.parseInt(req.getParameter("idVeicolo")));
            List<LocalDate> dateDaDisabilitare=new ArrayList<>();
            for(int i=0;i<dataFinePrenotazione.size();i++){
                for(LocalDate d=dataInizioPrenotazione.get(i); !d.isAfter(dataFinePrenotazione.get(i)); d=d.plusDays(1)){
                    dateDaDisabilitare.add(d);
                }
            }
            req.getSession().setAttribute("veicoloSelezionato", veicoloSelezionato);
            req.getSession().setAttribute("dateDaDisabilitare", dateDaDisabilitare);
            resp.setStatus(HttpServletResponse.SC_OK);
            req.getRequestDispatcher("rentcar.jsp").forward(req,resp);
        }

        else {
            LocalDate start=LocalDate.parse(req.getParameter("dataInizio"));
            LocalDate end=LocalDate.parse(req.getParameter("dataFine"));
            if(start.isBefore(end)){
                Prenotazioni prenotazione= new Prenotazioni(start, end,"PENDING", (Utente)req.getSession().getAttribute("utente"), (Veicoli)req.getSession().getAttribute("veicoloSelezionato"), LocalDate.now());
                prenotazioneDAO.save(prenotazione);
                System.out.println("ok");
                resp.setStatus(HttpServletResponse.SC_OK);
            }
            else resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            resp.sendRedirect("index.jsp");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
