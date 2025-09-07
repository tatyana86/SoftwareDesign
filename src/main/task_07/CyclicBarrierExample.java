package main.task_07;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    private static final int TEAM_SIZE = 4;

    public static void main(String[] args) {
        // когда все спортсмены готовы, объявляем старт
        CyclicBarrier barrier = new CyclicBarrier(TEAM_SIZE, () -> {
            System.out.println("Все спортсмены готовы! Старт!");
        });

        for (int i = 1; i <= TEAM_SIZE; i++) {
            new Thread(new Athlete(barrier, i)).start();
        }
    }

    static class Athlete implements Runnable {
        private CyclicBarrier barrier;
        private int athleteNumber;

        public Athlete(CyclicBarrier barrier, int athleteNumber) {
            this.barrier = barrier;
            this.athleteNumber = athleteNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Спортсмен " + athleteNumber + " тренируется...");
                Thread.sleep((long) (Math.random() * 3000));

                System.out.println("Спортсмен " + athleteNumber + " готов и ждет команду...");
                barrier.await();

                System.out.println("Спортсмен " + athleteNumber + " бежит эстафету!");
                Thread.sleep((long) (Math.random() * 2000));

                System.out.println("Спортсмен " + athleteNumber + " финишировал!");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
