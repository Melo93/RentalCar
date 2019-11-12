/*
package dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtils;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDAO<E> implements Serializable{

    private final Class<E> entity;

    public boolean save(E entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();

            session.save(entity);

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

    public List<E> getAllType(Class<E> entity) {
        List<E> t;
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();
            CriteriaQuery<E> cq = session.getCriteriaBuilder().createQuery(entity);
            Root<T> root = cq.from(T.class);
            cq.select(root);
            Query<T> query = session.createQuery(cq);
            t = query.getResultList();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            t = null;
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtils.shutdown();
        return t;
    }

}
*/
