package main.webapp;

import model.bean.Utente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

/*public class RentalCarMain {
    public static void main(String[] args) {

        Utente utente = new Utente("Ramesh", "Fadatare", "feretfdf", 6);
        Utente utente1 = new Utente("John", "Cena", "erdmfkng",6);
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            List <Utente> students = session.createQuery("from Utente", Utente.class).list();
            students.forEach(s -> System.out.println(s.toString()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}*/

