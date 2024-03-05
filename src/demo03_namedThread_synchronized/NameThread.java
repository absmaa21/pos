package demo03_namedThread_synchronized;

public class NameThread implements Runnable {

    private StringBuilder sb = new StringBuilder(10_000_000);

    public StringBuilder getSb() {
        return sb;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100_000; i++) {
            synchronized (sb) {
                sb.append(Thread.currentThread().getName()); // accesses the executing thread
            }
        }
    }

    public static void main(String[] args) {

        NameThread nameThread = new NameThread();

        Thread thread1 = new Thread(nameThread, "POS");
        Thread thread2 = new Thread(nameThread, "WMC");
        Thread thread3 = new Thread(nameThread, "DBI");

        // Start all the threads
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join(); // The calling thread waits until thread1 is finished
            thread2.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Whatever goes here, is executed as soon as all threads(1-3) are finished

        StringBuilder sb = nameThread.getSb();
        System.out.println("length: " + sb.length());
        System.out.println(sb.substring(0, 2500));
        // Let's calculate the expected length: 300.000 * 3 = 900.000

        // IMPORTANT
        // The length is different every time we run the program
        // The reason is, that the threads access sb as they like. They start overwriting values when they access sb at
        // the same time
        // Let's use the keyword "synchronized"
    }
}
