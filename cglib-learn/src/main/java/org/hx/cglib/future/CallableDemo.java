package org.hx.cglib.future;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class TaskWithResult implements Callable<String>
{

    public String call() throws Exception {
        // TODO Auto-generated method stub
        Thread.sleep(1000);
        return "OK";
    }

}
public class CallableDemo {

    /**
     * @param args
     * @throws Exception
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, Exception {
        // TODO Auto-generated method stub
        ExecutorService exec=Executors.newCachedThreadPool();
        Future<String> st=exec.submit(new TaskWithResult());

        /*同步结果，而且设置超时时间*/
        System.out.println(st.get(10000, TimeUnit.MILLISECONDS));
        System.out.println("over");
        exec.shutdown();



    }

}