package Exception_Test._01Test;

public class Bank {
    double balance;
    public Bank(double balance) {
        this.balance = balance;
    }
    public void withDraw(double amount) throws InsufficientBalanceException{
        if(amount > balance){
            throw new InsufficientBalanceException("当前余额：" + this.balance + "提取金额：" + amount);
        }else {
            this.balance -= amount;
            System.out.println("当前余额：" + this.balance);
        }
    }

    public static void main(String[] args) {
        new Bank(1000).withDraw(500);
    }
}
