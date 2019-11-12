package dao.impl;

import model.Ruolo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class RuoloDAO {

    public Ruolo findRoleFromDescription(String description){
        Ruolo ruolo;
        Transaction transaction=null;
        Session session=null;

        try{
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();
            ruolo = session.createQuery("from Ruolo where descrizione=:description", Ruolo.class)
                    .setParameter("description",description).getSingleResult();
        }
        catch (Exception e){
           if(transaction!=null){
               transaction.rollback();
           }
           ruolo=null;
           e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        HibernateUtils.shutdown();
        return ruolo;
    }

}
