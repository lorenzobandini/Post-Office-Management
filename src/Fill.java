import java.util.concurrent.LinkedBlockingQueue;

public class Fill implements Runnable {
    private static LinkedBlockingQueue<Person> coda;
    
    public Fill(LinkedBlockingQueue<Person> coda) {
        Fill.coda = coda;
    }

    @Override
    public void run(){
        for(int i = 0; i<100; i++){
            Person p = new Person();
            coda.add(p);
            System.out.println("Person arrived in the large room");
            try {
                Thread.sleep(35);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   

}
