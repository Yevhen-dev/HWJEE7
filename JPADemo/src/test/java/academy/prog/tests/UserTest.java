package academy.prog.tests;

import academy.prog.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class UserTest extends BaseTest{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPABank");
    static EntityManager em = emf.createEntityManager();


    @Test
    public void testUserGetUserByName() {

        System.out.println("----------------------------------------");
        String name = "Donald";
        User user = em.find(User.class, name);

        System.out.println(user);

    }

}
