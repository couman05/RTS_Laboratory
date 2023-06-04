package Session5.Lab7.App2ReentrantLock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        CyclicBarrier barrier = new CyclicBarrier(3);

        while (true) {
            ExecutionThread thread1 = new ExecutionThread(4, 4, 2, lock1, lock2, barrier);
            ExecutionThread thread2 = new ExecutionThread(3, 6, 3, lock1, lock2, barrier);
            ExecutionThread thread3 = new ExecutionThread(5, 5, 2, lock1, lock2, barrier);

            thread1.start();
            thread2.start();
            thread3.start();

            try {
                barrier.await();
                barrier.reset();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}

