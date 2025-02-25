package academy.prog;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountId")
    private long accountId;


    @Column( name = "amount")
    private String amount;

    @Column( name = "currency")
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "currency_id")
    private CurrencyRate cr;

    public CurrencyRate getCr() {
        return cr;
    }

    public void setCr(CurrencyRate cr) {
        this.cr = cr;
    }

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "account")
    private Set<Transaction> transactions;

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Account() {}

    public Account(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }



    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
