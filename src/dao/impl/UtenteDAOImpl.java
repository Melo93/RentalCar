package dao.impl;

import dao.UtenteDAO;
import model.bean.Utente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.LinkedList;
import java.util.List;

public class UtenteDAOImpl implements UtenteDAO {
    @Override
    public List<Utente> getAllUser() {
        List<Utente> utenti=new LinkedList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            utenti = session.createQuery("from Utente", Utente.class).list();
            utenti.forEach(s -> System.out.println(s.toString()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return utenti;
    }
}
