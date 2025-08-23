package test.task_02;

import main.task_02.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0);
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdraw() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 0.001);
    }

    @Test
    void testGetBalance() {
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    void testZeroBalance() {
        BankAccount zeroAccount = new BankAccount(0.0);
        assertEquals(0.0, zeroAccount.getBalance(), 0.001);

        zeroAccount.deposit(50.0);
        assertEquals(50.0, zeroAccount.getBalance(), 0.001);
    }

    @Test
    void testMultiOperations() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);

        // отрицательная сумма баланса достижима
        account.withdraw(200);
        assertEquals(-50, account.getBalance(), 0.001);
    }

}
