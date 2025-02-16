//package academy.prog;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "transactions")
//public class Transaction {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "transactionId")
//    private long transactionId;
//
//    @Column(name = "fromUser")
//    private String fromUser;
//
//    @Column(name = "fromAccount")
//    private String fromAccount;
//
//    @Column( name = "toUser")
//    private String toUser;
//
//    @Column( name = "toAccount")
//    private String toAccount;
//
//    @Column( name = "amount")
//    private int amount;
//
//    @Column( name = "currency")
//    private String currency;
//
//    @Column( name = "moneyInOut")
//    private String moneyInOut;
//
//    public Transaction(String fromUser, String fromAccount, String toUser, String toAccount, int amount, String currency, String moneyInOut) {
//        this.fromUser = fromUser;
//        this.fromAccount = fromAccount;
//        this.toUser = toUser;
//        this.toAccount = toAccount;
//        this.amount = amount;
//        this.currency = currency;
//        this.moneyInOut = moneyInOut;
//    }
//
//    public Transaction() {}
//
//    public long getTransactionId() {
//        return transactionId;
//    }
//
//    public void setTransactionId(long transactionId) {
//        this.transactionId = transactionId;
//    }
//
//    public String getFromUser() {
//        return fromUser;
//    }
//
//    public void setFromUser(String fromUser) {
//        this.fromUser = fromUser;
//    }
//
//    public String getFromAccount() {
//        return fromAccount;
//    }
//
//    public void setFromAccount(String fromAccount) {
//        this.fromAccount = fromAccount;
//    }
//
//    public String getToUser() {
//        return toUser;
//    }
//
//    public void setToUser(String toUser) {
//        this.toUser = toUser;
//    }
//
//    public String getToAccount() {
//        return toAccount;
//    }
//
//    public void setToAccount(String toAccount) {
//        this.toAccount = toAccount;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public String getInOut() {
//        return moneyInOut;
//    }
//
//    public void setInOut(String inOut) {
//        this.moneyInOut = inOut;
//    }
//
//    @Override
//    public String toString() {
//        return "Transaction{" +
//                "transactionId=" + transactionId +
//                ", fromUser='" + fromUser + '\'' +
//                ", fromAccount='" + fromAccount + '\'' +
//                ", toUser='" + toUser + '\'' +
//                ", toAccount='" + toAccount + '\'' +
//                ", amount=" + amount +
//                ", currency='" + currency + '\'' +
//                ", inOut='" + moneyInOut + '\'' +
//                '}';
//    }
//}
