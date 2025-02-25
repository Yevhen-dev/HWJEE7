package academy.prog;

import javax.persistence.Query;

import java.util.List;

import static academy.prog.App.em;

public class AccountSystem {

    public Account getAccountByCurrency(User user, String currency ) {
        Account account = new Account();
        long userId = user.getUserId();
        Query query = em.createQuery("SELECT acc FROM Account acc where user_id = :userId", Account.class);
        query.setParameter("userId", userId);

        List<Account> accounts = query.getResultList();

        String curUpCase = currency.toUpperCase();
        for ( Account acc : accounts ) {
            if( acc.getCurrency().equals(curUpCase) ) {
                account = acc;
            }
        }
        return account;
    }

    public void topUpAccount( Account account, int sum ) {
        int res = Integer.parseInt(account.getAmount()) + sum;
        account.setAmount(String.valueOf(res));
        saveAccountToDB(account);

        new TransactionSystem().createTransaction(account, sum, account.getCurrency());
//                createTansaction( account, sum, account.getCurrency() );
    }

    public void saveAccountToDB(Account account) {
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void sendMoney( Account fromAccount, int sum, Account toAccount ) {

        if( fromAccount.getCurrency().equals( toAccount.getCurrency() ) ) {
            int minusMoney = Integer.parseInt(fromAccount.getAmount()) - sum;
            if( minusMoney < 0 ) {
                System.out.println("You don't have enough money");
            } else {
                fromAccount.setAmount(String.valueOf(minusMoney));
                saveAccountToDB(fromAccount);

                new TransactionSystem().createTransaction(fromAccount, -sum, fromAccount.getCurrency());

                int plusMoney = Integer.parseInt(toAccount.getAmount()) + sum;
                toAccount.setAmount(String.valueOf(plusMoney));
                saveAccountToDB(toAccount);

                new TransactionSystem().createTransaction(toAccount, sum, toAccount.getCurrency());
            }
        } else {
            System.out.println("Sorry, you can`t transfer money to account with different currency");
            return;
        }
    }

    public void exchangeCurrency( Account fromAccount, Account toAccount, int sum ) {

        int balanceAfterExchange = Integer.parseInt(fromAccount.getAmount()) - sum;

        if( balanceAfterExchange < 0 ) {
            System.out.println("You don't have enough money");
        } else {

            fromAccount.setAmount(String.valueOf(balanceAfterExchange));
            saveAccountToDB(fromAccount);
            new TransactionSystem().createTransaction(fromAccount, -sum, fromAccount.getCurrency());


            if( fromAccount.getCurrency().equals( "UAH" ) && ( toAccount.getCurrency().equals( "USD" ) || toAccount.getCurrency().equals( "EUR" ) ) ) {
                double exchangeRes = sum / toAccount.getCr().getSell();
                calculateMoneyAfterExchange(toAccount, exchangeRes);
            } else if ( ( fromAccount.getCurrency().equals( "EUR" ) || fromAccount.getCurrency().equals( "USD" )  ) && toAccount.getCurrency().equals( "UAH" )) {
                double exchangeRes = sum * fromAccount.getCr().getBuy();
                calculateMoneyAfterExchange(toAccount, exchangeRes);
            } else if( ( fromAccount.getCurrency().equals( "EUR" ) && toAccount.getCurrency().equals( "USD" ) ) || ( fromAccount.getCurrency().equals( "USD" ) && toAccount.getCurrency().equals( "EUR" ) ) ) {
                double exchangeRes = ( sum * fromAccount.getCr().getBuy() )/ toAccount.getCr().getSell();
                calculateMoneyAfterExchange(toAccount, exchangeRes);
            }

        }

    }

    public void getTotalSumOfMoneyOnAllAccountsInUAH( User user ) {
        long userId = user.getUserId();

        Query query = em.createQuery("SELECT acc FROM Account acc where user_id = :userId", Account.class);
        query.setParameter("userId", userId);

        double totalSumInUAH = 0;
        List<Account> accounts = query.getResultList();
        for ( Account acc : accounts ) {
            if( acc.getCurrency().equals( "UAH" ) ) {
                totalSumInUAH += Double.parseDouble(acc.getAmount());
            } else {
                totalSumInUAH += Double.parseDouble(acc.getAmount()) * acc.getCr().getBuy();
            }
        }
        System.out.println(totalSumInUAH);
    }


    private void calculateMoneyAfterExchange(Account toAccount, double exchangeRes) {
        double roundedExchangeRes = Math.round(exchangeRes * 100.0) / 100.0;
        double balanceAfterTransfer = Integer.parseInt(toAccount.getAmount()) + roundedExchangeRes;
        toAccount.setAmount(String.valueOf(balanceAfterTransfer));
        saveAccountToDB(toAccount);

        new TransactionSystem().createTransaction(toAccount, roundedExchangeRes, toAccount.getCurrency());
    }

}
