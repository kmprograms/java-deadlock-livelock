public class App2 {
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        new Thread(deadlock::action1).start();
        new Thread(deadlock::action2).start();
    }
}
