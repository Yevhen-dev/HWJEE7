package academy.prog;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "rate")
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "currencyId")
    private long accountId;

    @Column( name = "currencyName")
    private String name;

    @Column( name = "buy")
    private double buy;

    @Column( name = "sell")
    private double sell;

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "cr")
    private Set<Account> accounts;

    public CurrencyRate(String name, double buy, double sell) {
        this.name = name;
        this.buy = buy;
        this.sell = sell;
    }
    public CurrencyRate() {}

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }
}
