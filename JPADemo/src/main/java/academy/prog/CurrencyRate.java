//package academy.prog;
//
//import javax.persistence.*;
//
//@Entity
//@Table( name = "rate")
//public class CurrencyRate {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "currencyId")
//    private long accountId;
//
//    @Column( name = "buy")
//    private String buy;
//
//    @Column( name = "sell")
//    private String sell;
//
//    public CurrencyRate(String buy, String sell) {
//        this.buy = buy;
//        this.sell = sell;
//    }
//
//    public CurrencyRate() {}
//
//    public long getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(long accountId) {
//        this.accountId = accountId;
//    }
//
//    public String getBuy() {
//        return buy;
//    }
//
//    public void setBuy(String buy) {
//        this.buy = buy;
//    }
//
//    public String getSell() {
//        return sell;
//    }
//
//    public void setSell(String sell) {
//        this.sell = sell;
//    }
//
//    @Override
//    public String toString() {
//        return "CurrencyRate{" +
//                "accountId=" + accountId +
//                ", buy='" + buy + '\'' +
//                ", sell='" + sell + '\'' +
//                '}';
//    }
//}
