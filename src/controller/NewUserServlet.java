package controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.RuoloDAO;
import dao.impl.UtenteDAO;
import model.Ruolo;
import model.Utente;

import javax.ejb.Init;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "NewUserServlet", urlPatterns = "/newProfile")
public class NewUserServlet extends HttpServlet {
    UtenteDAO utenteDAO;
    RuoloDAO ruoloDAO;

    @Override
    public void init() throws ServletException {
        utenteDAO = new UtenteDAO();
        ruoloDAO=new RuoloDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = req.getParameter("jsonUserInfo");
        String jsonRuolo=req.getParameter("jsonRuolo");

        if (jsonString != null) {
            ObjectMapper mapper = new ObjectMapper();
            Ruolo temp = mapper.readValue(jsonRuolo, Ruolo.class);
            temp=ruoloDAO.findRoleFromDescription(temp.getDescrizione());
            Utente jsonUtente = mapper.readValue(jsonString, Utente.class);
            temp.getUtenti().add(jsonUtente);
            jsonUtente.setRuolo(temp);
            if (utenteDAO.save(jsonUtente)) {
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
            resp.sendRedirect("index.jsp");
        }

        return;
    }

}
