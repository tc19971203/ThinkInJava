package holdingObjects.thread;

import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.objects.Global.print;

public class SimpleDaemons implements Runnable{



    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread()+" "+this);
            }
        } catch (InterruptedException e){
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {

         byte a1 = 2, a2 = 4, a3;
         short s = 16;
         a2 = (byte)s;
         a3 = (byte) (a1 * a2);


    }
}
