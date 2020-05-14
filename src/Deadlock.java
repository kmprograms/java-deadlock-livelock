import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public void action1() {
        try {
            lock1.lock();
            System.out.println("LOCK1 IS BLOCKED");
            TimeUnit.MILLISECONDS.sleep(200);

            lock2.lock();
            System.out.println("LOCK2 IS BLOCKED");
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void action2() {
        try {

            lock2.lock();
            System.out.println("LOCK2 IS BLOCKED");
            TimeUnit.MILLISECONDS.sleep(200);

            lock1.lock();
            System.out.println("LOCK1 IS BLOCKED");
            TimeUnit.MILLISECONDS.sleep(200);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }
}
