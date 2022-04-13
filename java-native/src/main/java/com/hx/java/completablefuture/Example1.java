package com.hx.java.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.lang.Character.isUpperCase;
import static org.junit.Assert.*;

/**
 * https://zhuanlan.zhihu.com/p/34921166
 *
 * @author 35762
 */
public class Example1 {

  static void runAsyncExample() throws InterruptedException {
    CompletableFuture cf = CompletableFuture.runAsync(() -> {
      assertTrue(Thread.currentThread().isDaemon());
      sleepRandom();
    });
    assertFalse(cf.isDone());
    sleepEnough();
    assertTrue(cf.isDone());
  }

  private static void sleepEnough() throws InterruptedException {
    Thread.sleep(2000);
  }

  private static void sleepRandom() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static void completedFutureExample() {
    CompletableFuture cf = CompletableFuture.completedFuture("message");
    assertTrue(cf.isDone());
    assertEquals("message", cf.getNow(null));
  }

  static void thenApplyExample() {
    CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(
      s -> {
        assertFalse(Thread.currentThread().isDaemon());
        return s.toUpperCase();
      }
    );
    assertEquals("MESSAGE", cf.getNow(null));
  }

  static void allOfExample() throws ExecutionException, InterruptedException {
    StringBuilder result = new StringBuilder();
    List messages = Arrays.asList("a", "b", "c");
    List<CompletableFuture> futures = (List<CompletableFuture>) messages.stream()
      .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> {
        assertFalse(Thread.currentThread().isDaemon());
        try {
          System.out.println(Thread.currentThread().getId());
          System.out.println(Thread.currentThread().getName());
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return s.toString();
      }))
      .collect(Collectors.toList());

    for (CompletableFuture future : futures) {
      System.out.println(future.isDone());
    }

    for (int i = 0; i < futures.size(); i++) {
      boolean done = futures.get(i).isDone();
      System.out.println(done);
      result.append(futures.get(i).get());
    }
    CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]));

    System.out.println(result.toString());
  }


  static void thenAcceptAsyncExample() {
    StringBuilder result = new StringBuilder();
    CompletableFuture cf = CompletableFuture.completedFuture("thenAcceptAsync message")
      .thenAcceptAsync(s -> result.append(s));
    cf.join();
    assertTrue("Result was empty", result.length() > 0);
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
//    easydemo();
//    completedFutureExample();
//    runAsyncExample();
//    thenApplyExample();
//    allOfExample();
    thenAcceptAsyncExample();

  }

  private static void easydemo() throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    Future future = executor.submit(new Callable<String>() {

      @Override
      public String call() throws Exception {
        //do some thing
        Thread.sleep(1000);
        return "i am ok";
      }
    });
    boolean done = future.isDone();
    System.out.println(future.isDone());
    System.out.println(future.get());
    System.out.println(future.isDone());
    executor.shutdown();
  }
}
