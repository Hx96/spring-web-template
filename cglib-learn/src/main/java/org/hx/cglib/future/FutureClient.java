package org.hx.cglib.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureClient {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        FutureUsage futureUsage = new FutureUsage();
        Future<Integer> calculate = futureUsage.calculate(100);
//        while (!calculate.isDone()) {
//            System.out.println("Calculating...");
//            Thread.sleep(300);
//        }
//        Integer result = calculate.get();
//        System.out.println(result);

        Integer result = calculate.get(2000, TimeUnit.MILLISECONDS);
        System.out.println(result);
        boolean cancel = calculate.cancel(true);
        System.out.println(cancel);


        Future<Integer> future1 = futureUsage.calculate(10);
        Future<Integer> future2 = futureUsage.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }
        futureUsage.shutDown();
    }
}
