import java.util.Random;

public class Person implements Runnable{
    @Override
    public void run() {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(120)+1);
            System.out.println("Person assigned to "+ Thread.currentThread().getName() + " executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
