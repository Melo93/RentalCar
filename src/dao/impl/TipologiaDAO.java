package dao.impl;

import model.Categoria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TipologiaDAO {

    public List<Categoria> getAllType() {
        List<Categoria> categorie;
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();
            CriteriaQuery<Categoria> cq = session.getCriteriaBuilder().createQuery(Categoria.class);
            Root<Categoria> root = cq.from(Categoria.class);
            cq.select(root);
            Query<Categoria> query = session.createQuery(cq);
            categorie = query.getResultList();
            System.out.println(categorie.toString());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            categorie = null;
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtils.shutdown();
        return categorie;
    }

    public Categoria getTypeById(int idCategoria) {
        Categoria categoria;
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtils.getHibernateSession();
            transaction = session.beginTransaction();
            CriteriaQuery<Categoria> cq = session.getCriteriaBuilder().createQuery(Categoria.class);
            Root<Categoria> root = cq.from(Categoria.class);
            cq.select(root).where(session.getCriteriaBuilder().equal(root.get("id"),idCategoria));
            Query<Categoria> query = session.createQuery(cq);
            categoria = query.getSingleResult();
            System.out.println(categoria.toString());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            categoria = null;
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtils.shutdown();
        return categoria;
    }


}
