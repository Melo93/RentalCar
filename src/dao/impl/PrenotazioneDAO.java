package dao.impl;

import model.Prenotazioni;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrenotazioneDAO {

    public boolean save(Prenotazioni prenotazione) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();

            session.save(prenotazione);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }

        }
        HibernateUtils.shutdown();
        return true;
    }


    public List<LocalDate> getBookingStartDateByCarId(int idVeicolo) {
        List<LocalDate> prenotazioni = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();

            prenotazioni = session.createQuery("select dataInizio from Prenotazioni P where P.veicolo.id = :idVeicolo and P.stato= 'APPROVED' ", LocalDate.class)
                    .setParameter("idVeicolo", idVeicolo)
                    .list();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        HibernateUtils.shutdown();
        return prenotazioni;
    }

    public List<LocalDate> getBookingFinishDateByCarId(int idVeicolo) {
        List<LocalDate> prenotazioni = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();

            prenotazioni = session.createQuery("select dataFine from Prenotazioni P where P.veicolo.id = :idVeicolo and P.stato= 'APPROVED' ", LocalDate.class)
                    .setParameter("idVeicolo", idVeicolo)
                    .list();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        HibernateUtils.shutdown();
        return prenotazioni;
    }

    public List<Prenotazioni> getBookingInPending() {
        List<Prenotazioni> prenotazioni = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();

            prenotazioni = session.createQuery("from Prenotazioni P where P.stato = 'PENDING' ", Prenotazioni.class)
                    .list();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        HibernateUtils.shutdown();
        return prenotazioni;
    }

    public void updateBookingState(String state, int id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();

            session.createQuery("update Prenotazioni P set P.stato=:state where P.id = :id ")
                   .setParameter("state", state).setParameter("id", id).executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        HibernateUtils.shutdown();

    }

    public List<Prenotazioni> getBookingHistory() {
        List<Prenotazioni> prenotazioni = new ArrayList<>();
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();

            prenotazioni = session.createQuery("from Prenotazioni P where P.stato != 'PENDING' ", Prenotazioni.class)
                    .list();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
        HibernateUtils.shutdown();
        return prenotazioni;
    }
}
