package main.task_07;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

    private int value = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public int read() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(int newValue) {
        lock.writeLock().lock();
        try {
            value = newValue;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockExample shared = new ReentrantReadWriteLockExample();

        new Thread(() -> {
            System.out.println("Read: " + shared.read());
        }).start();

        new Thread(() -> {
            shared.write(42);
            System.out.println("Written 42");
        }).start();
    }

}
