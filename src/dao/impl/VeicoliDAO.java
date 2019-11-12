package dao.impl;

import model.Veicoli;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.LinkedList;
import java.util.List;

public class VeicoliDAO {

    public List<Veicoli> getAllVeicles(){
        List<Veicoli> veicoli = new LinkedList<>();
        Transaction transaction = null;
        Session session = null;
        try{
            session= HibernateUtils.getHibernateSession();
            veicoli = session.createQuery("select v from Veicoli v").list();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            veicoli=null;
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        HibernateUtils.shutdown();

        return veicoli;
    }

    public Veicoli getVeicleById(int id){
        Veicoli veicolo = new Veicoli();
        Transaction transaction = null;
        Session session = null;
        try{
            session= HibernateUtils.getHibernateSession();
            veicolo = session.get(Veicoli.class,id);
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            veicolo=null;
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        HibernateUtils.shutdown();

        return veicolo;
    }

    public boolean saveOrUpdate(Veicoli veicolo){
        Transaction transaction = null;
        Session session=null;
        try {
            session=HibernateUtils.getHibernateSession();
            transaction= session.beginTransaction();

            session.saveOrUpdate(veicolo);

            transaction.commit();
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        finally {
            if(session!=null){
                session.close();
            }

        }
        HibernateUtils.shutdown();
        return true;
    }

}
