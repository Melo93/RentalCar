package controller;

import dao.impl.TipologiaDAO;
import dao.impl.VeicoliDAO;
import model.Categoria;
import model.Veicoli;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/newCar")
public class AddCarServlet extends HttpServlet {

    VeicoliDAO veicoliDAO;
    TipologiaDAO tipologiaDAO;

    @Override
    public void init() throws ServletException {
        veicoliDAO=new VeicoliDAO();
        tipologiaDAO= new TipologiaDAO();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String costruttore=req.getParameter("costruttore");
        String modello=req.getParameter("modello");
        String targa=req.getParameter("targa");
        int anno=Integer.parseInt(req.getParameter("anno"));
        int prezzo= Integer.parseInt(req.getParameter("prezzo"));
        Categoria tipologia= tipologiaDAO.getTypeById(Integer.parseInt(req.getParameter("ruolo")));
        String url=req.getParameter("url");
        Veicoli veicolo= new Veicoli(targa,costruttore,modello,anno,tipologia,prezzo,url);

        if(veicoliDAO.saveOrUpdate(veicolo)){
            List<Veicoli> veicoli= veicoliDAO.getAllVeicles();
            req.getSession().setAttribute("veicoli", veicoli);
            resp.setStatus(HttpServletResponse.SC_OK);
            System.out.println("ok");
        }
        else{
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.sendRedirect("index.jsp");
    }
}
