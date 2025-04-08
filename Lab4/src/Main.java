import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // === a) CountDownLatch ===
        int threadCount = 3;
        CountDownLatch latch = new CountDownLatch(threadCount);

        System.out.println("Main thread waiting for " + threadCount + " worker threads...");

        for (int i = 0; i < threadCount; i++) {
            final int id = i + 1;
            new Thread(() -> {
                System.out.println("Thread " + id + " started.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + id + " finished.");
                latch.countDown();
            }).start();
        }

        latch.await();
        System.out.println("All threads completed. Main thread continues.\n");

        // === b) Клас-нащадок + рефлексія ===
        MySubClass myObj = new MySubClass();
        Class<?> clazz = myObj.getClass();

        System.out.println("Superclass: " + clazz.getSuperclass().getName());

        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println("Implemented interfaces:");
        for (Class<?> iFace : interfaces) {
            System.out.println("- " + iFace.getName());
        }

        // === c) Узагальнений метод ===
        System.out.println("\nCompare generics:");
        System.out.println("Max of 5 and 9 is: " + Utils.getMax(5, 9));
        System.out.println("Max of 'apple' and 'banana' is: " + Utils.getMax("apple", "banana"));
    }
}
