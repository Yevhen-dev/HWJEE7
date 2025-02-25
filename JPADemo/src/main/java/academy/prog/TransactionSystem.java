package academy.prog;

import static academy.prog.App.em;

public class TransactionSystem {

    public void saveTransactionToDB ( Transaction transaction ) {
        try {
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void createTransaction ( Account account, double sum, String currency  ) {
        Transaction transaction = new Transaction(sum, currency.toUpperCase());
        transaction.setAccount(account);
        saveTransactionToDB(transaction);
    }

}
