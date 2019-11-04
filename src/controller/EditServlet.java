package controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.UtenteDAO;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "EditServlet", urlPatterns = "/editProfile")
public class EditServlet extends HttpServlet {
    UtenteDAO utenteDAO;

    @Override
    public void init() throws ServletException {
        utenteDAO=new UtenteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String jsonString = request.getParameter("jsonUserInfo");
        if (jsonString != null) {
            ObjectMapper mapper = new ObjectMapper();
            Utente jsonUtente = mapper.readValue(jsonString, Utente.class);
            System.out.println(jsonUtente);
            HttpSession httpSession = request.getSession();
            Utente utente = (Utente)httpSession.getAttribute("utente");
            try {
                utente.overwrite(jsonUtente);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(utente);
            utenteDAO.save(utente);
            request.getSession().setAttribute("utente",utente);
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("/index.jsp");
        }

        return;
    }

}

