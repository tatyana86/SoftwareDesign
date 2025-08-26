package main.task_02;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    };

    public void deposit(double depositValue) {
        if (depositValue < 0) {
            throw new IllegalArgumentException("Deposit value should be positive!");
        }
        this.balance += depositValue;
    }

    public void withdraw(double withdrawValue) {
        if (withdrawValue <= 0) {
            throw new IllegalArgumentException("Withdraw value should be positive!");
        }
        if (this.balance < withdrawValue) {
            throw new RuntimeException("There is not enough balance.");
        }
        this.balance -= withdrawValue;
    }

    public double getBalance() {
        return this.balance;
    }

}
