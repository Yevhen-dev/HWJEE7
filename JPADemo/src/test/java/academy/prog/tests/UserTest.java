package academy.prog.tests;

import academy.prog.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;


public class UserTest extends BaseTest{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPABank");
    static EntityManager em = emf.createEntityManager();


    @Test
    public void testUserGetUserByName() {

        System.out.println("----------------------------------------");
        Query query = em.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();

        for( User u : users ) {
            System.out.println(u.getName());
        }


    }

}
