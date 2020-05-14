public class App3 {
    public static void main(String[] args) {
        Livelock livelock = new Livelock();
        new Thread(livelock::action1).start();
        new Thread(livelock::action2).start();
    }
}
