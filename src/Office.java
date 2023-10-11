import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;

public class Office {
    public static void main(String[] args) throws Exception {
        
        // thread pool con la propria coda di dimensione k
        System.out.print("Enter the number of people staying in the smallest room: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        reader.close();
    
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,4,2,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(k),new ThreadPoolExecutor.CallerRunsPolicy());

        //coda LinkedBlockingQueue di Persone illimitata per la seconda stanza

        LinkedBlockingQueue<Person> coda = new LinkedBlockingQueue<>();

        //thread che riempie la coda
        Thread riempitore = new Thread(new Fill(coda));
        riempitore.start();

        //thread che pesca dalla coda e mette in esecuzione il thread pool
        Thread sposta = new Thread(new Move(coda,executor));
        sposta.start();

        

        try{
            riempitore.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        try{
            sposta.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        executor.shutdown();
        while(!executor.isTerminated()){
            Thread.sleep(50);
        };

    }
}
