package academy.prog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App {

    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("JPABank");
        em = emf.createEntityManager();

        initDB();

        User bob = new UserSystem().getUserByName("Bob");
        Account bobAccountUAH = new AccountSystem().getAccountByCurrency(bob, "UAH");
        Account bobAccountUSD = new AccountSystem().getAccountByCurrency(bob, "USD");
        Account bobAccountEUR = new AccountSystem().getAccountByCurrency(bob, "EUR");
        new AccountSystem().topUpAccount(bobAccountUAH, 300);

        User donald = new UserSystem().getUserByName("Donald");
        Account donaldAccountUSD = new AccountSystem().getAccountByCurrency(donald, "USD");
        Account donaldAccountUAH = new AccountSystem().getAccountByCurrency(donald, "UAH");

        new AccountSystem().sendMoney(bobAccountUAH, 7500, donaldAccountUAH);
        new AccountSystem().exchangeCurrency(bobAccountUSD, bobAccountEUR, 100);

        new AccountSystem().getTotalSumOfMoneyOnAllAccountsInUAH(donald);


        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter account number: ");
            String input = sc.nextLine();
        }

    }

    private static void initDB() {

        CurrencyRate crUSD = new CurrencyRate( "USD", 5.0,5.5);
        CurrencyRate crEUR = new CurrencyRate( "EUR", 6.5,7.5);
        CurrencyRate crUAH = new CurrencyRate( "UAH", 1.0,1.0);;
        new CurrencyRateSystem().saveCurrencyRateToDB(crUSD);
        new CurrencyRateSystem().saveCurrencyRateToDB(crEUR);
        new CurrencyRateSystem().saveCurrencyRateToDB(crUAH);

        User don = new User("Donald", "donald@gmail.com");
        User bob = new User("Bob", "bob@gmail.com");
        User john = new User("John", "john@gmail.com");
        List<User> users = new ArrayList<>();
        users.add(don);
        users.add(bob);
        users.add(john);

        Account accDUSD = new Account("600", "USD");
        Account accDUAH = new Account("2600", "UAH");
        accDUSD.setUser(don);
        accDUSD.setCr(crUSD);
        accDUAH.setUser(don);
        accDUAH.setCr(crUAH);


        Account accBUSD = new Account("830", "USD");
        Account accBUAH = new Account("6700", "UAH");
        Account accBEUR = new Account("250", "EUR");
        accBUSD.setUser(bob);
        accBUSD.setCr(crUSD);
        accBUAH.setUser(bob);
        accBUAH.setCr(crUAH);
        accBEUR.setUser(bob);
        accBEUR.setCr(crEUR);

        Account accJEUR = new Account("480", "EUR");
        Account accJUAH = new Account("5800", "UAH");
        accJEUR.setUser(john);
        accJEUR.setCr(crEUR);
        accJUAH.setUser(john);
        accJUAH.setCr(crEUR);

        List<Account> accounts = new ArrayList<>();
        accounts.add(accDUSD);
        accounts.add(accDUAH);
        accounts.add(accBUSD);
        accounts.add(accBUAH);
        accounts.add(accBEUR);
        accounts.add(accJEUR);
        accounts.add(accJUAH);

        for( User user : users ) {
            new UserSystem().saveUserToDB(user);
        }

        for( Account account : accounts ) {
            new AccountSystem().saveAccountToDB(account);
        }

    }





}
