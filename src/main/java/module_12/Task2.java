package module_12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {
    public static volatile AtomicInteger number = new AtomicInteger(20);
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(5);
        FizzBuzz fizzBuzzService = new FizzBuzz();

        service.submit(fizzBuzzService::fizz);
        service.submit(fizzBuzzService::buzz);
        service.submit(fizzBuzzService::fizzbuzz);
        service.submit(fizzBuzzService::number);
        service.submit(fizzBuzzService::print);
    }
}
