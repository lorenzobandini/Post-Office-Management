import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Move implements Runnable {
    private static LinkedBlockingQueue<Person> coda;
    private static ThreadPoolExecutor executor;
    
    public Move(LinkedBlockingQueue<Person> coda, ThreadPoolExecutor executor) {
        Move.coda = coda;
        Move.executor = executor;
    }

    @Override
    public void run(){
        for(int i=0; i<100; i++){
            Person p = coda.poll();
            System.out.println("Person moved");
            if(p != null){
                System.out.println("Person inside the smallest room");
                executor.execute(p);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
