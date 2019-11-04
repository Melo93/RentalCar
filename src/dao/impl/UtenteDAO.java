package dao.impl;

import model.Utente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.LinkedList;
import java.util.List;

public class UtenteDAO {

    public List<Utente> getAllUser() {
        List<Utente> utenti = new LinkedList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtils.getHibernateSession()) {
            utenti = session.createQuery("from Utente", Utente.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return utenti;
    }

    public Utente getUserByUsernameAndPassword(String username, String password) {
        Utente utente = new Utente();
        Transaction transaction = null;
        Session session=null;
        try {
            session = HibernateUtils.getHibernateSession();
            utente = session.createQuery(
                    "from Utente U where U.username=:username and U.password=:password",
                    Utente.class
            ).setParameter("username", username).setParameter("password", password).getSingleResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            utente=null;
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        HibernateUtils.shutdown();

        return utente;
    }

    public void save(Utente utente){

        Transaction transaction=null;
        Session session=null;

        try {
            session=HibernateUtils.getHibernateSession();
            transaction= session.beginTransaction();

            session.update(utente);

            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        HibernateUtils.shutdown();

    }
}
