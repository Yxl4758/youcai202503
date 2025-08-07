package com.youcai.day09._DeadLock;

public class OrderedLocking {
    private static final Object tieLock = new Object();

    public static void main(String[] args) {
        OrderedLocking o = new OrderedLocking();
        Account from = new Account(1000);
        Account to = new Account(500);
        o.transferMoney(from,to,200);
    }
    
    public void transferMoney(Account fromAccount, Account toAccount, double amount) {
        class Helper {
            public void transfer() {
                if (fromAccount.getBalance() < amount) {
                    throw new IllegalArgumentException("余额不足");
                }
                fromAccount.debit(amount);
                toAccount.credit(amount);
            }
        }
        
        // 根据对象的hashCode确定锁的顺序
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);
        
        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            // 处理hashCode相同的情况
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }
}

class Account {
    private double balance;
    public Account(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void debit(double amount) {
        balance -= amount;
    }
    public void credit(double amount) {
        balance += amount;
    }
}