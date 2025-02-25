package academy.prog;

import javax.persistence.Query;

import java.util.List;

import static academy.prog.App.em;

public class UserSystem {

    public User getUserByName(String name) {
        User user = new User();
        Query query = em.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();

        for( User u : users ) {
            if( u.getName().equals( name ) ) {
                user = u;
            }
        }
        return user;
    }

    public void saveUserToDB(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

}
