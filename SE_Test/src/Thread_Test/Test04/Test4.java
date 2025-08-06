package Thread_Test.Test04;

import org.junit.Test;

public class Test4 {
    static BankAccount bankAccount = new BankAccount(100);

    public static void main(String[] args) {
        Thread withDrowThread = new Thread(() -> {
            while (true) {
                if (bankAccount.getBalance() > 0) {
                    System.out.println("withDrowThread：");
                    bankAccount.withDrow((int)(Math.random()*20));
                    System.out.print(bankAccount);
                    Thread.yield();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    break;
                }
            }
        });
        Thread depositThread = new Thread(() -> {
            while (true){
                if (bankAccount.getBalance() > 0){
                    System.out.print("depositThread：");
                    bankAccount.deposit((int)(Math.random()*10));
                    System.out.println(bankAccount);
                    Thread.yield();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    break;
                }
            }
        });
        withDrowThread.start();
        depositThread.start();
    }
}
class BankAccount{
    private int balance;

    public BankAccount(int balance) {
        synchronized (this){
            this.balance = balance;
        }
    }
    public void withDrow(int amount) {
        this.balance -= amount;
    }
    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "当前余额：" + balance;
    }
}