package academy.prog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class App {

    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("JPABank");
        em = emf.createEntityManager();

        User sam = new User("sam", "sam@gmail.com");

        try {
            em.getTransaction().begin();
            em.persist(sam);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }



        Account samUSD = new Account("200", "USD");
        samUSD.setUser(sam);

        try {
            em.getTransaction().begin();
            em.persist(samUSD);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        Account samEUR = new Account("500", "EUR");
        samEUR.setUser(sam);

        try {
            em.getTransaction().begin();
            em.persist(samEUR);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        sam.setAccounts(List.of(samUSD, samEUR));


        try {
            em.getTransaction().begin();
            em.persist(sam);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        Query query = em.createQuery("SELECT user FROM User user", User.class);
        List<User> users = (List<User>) query.getResultList();

        for (User user : users){
            System.out.println("-------------------------------------------");
            System.out.println(user);
        }


        

    }

}
