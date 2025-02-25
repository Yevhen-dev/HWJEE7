package academy.prog;

import static academy.prog.App.em;

public class CurrencyRateSystem {

    public void saveCurrencyRateToDB( CurrencyRate cr ) {
        try {
            em.getTransaction().begin();
            em.persist(cr);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

}
