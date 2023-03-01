package module_12;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class FizzBuzz {
    private final int n = 20;
    public static volatile AtomicInteger number = new AtomicInteger(1);

    public BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public synchronized void add(String element){
        queue.add(element);
    }
    public synchronized void fizz() {
        while (number.get() < n) {
            if (number.get() % 3 == 0 && number.get() % 5 != 0) {
                add("fizz");
                number.incrementAndGet();
                this.notifyAll();
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz() {
        while (number.get() < n) {
            if (number.get() % 3 != 0 && number.get() % 5 == 0) {
                add("buzz");
                number.incrementAndGet();
                this.notifyAll();
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzbuzz () {
        while (number.get() < n) {
            if (number.get() % 3 == 0 && number.get() % 5 == 0) {
                add("fizzbuzz");
                number.incrementAndGet();
                this.notifyAll();
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public synchronized void number() {
        while (number.get() < n) {
            if (number.get() % 3 != 0 && number.get() % 5 != 0) {
                add(String.valueOf(number));
                number.incrementAndGet();
                this.notifyAll();
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

        public void print() {
           while (true) {
               try {
                   sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               while (!queue.isEmpty()) {
                   System.out.println(queue.poll());
               }
           }
        }
}
