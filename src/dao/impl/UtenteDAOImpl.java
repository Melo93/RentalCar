package dao.impl;

import model.bean.Utente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.LinkedList;
import java.util.List;

public class UtenteDAOImpl {

    public List<Utente> getAllUser() {
        List<Utente> utenti=new LinkedList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            utenti = session.createQuery("from Utente", Utente.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return utenti;
    }

    public Utente getUserByUsernameAndPassword(String username, String password){
        Utente utente=new Utente();
        Transaction transaction=null;
        try(Session session=HibernateUtils.getSessionFactory().openSession()){
            utente = session.createQuery("from Utente U where U.username=username and U.password=password", Utente.class).getSingleResult();
        }
        catch (Exception e){
            if(transaction!=null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return utente;
    }
}
