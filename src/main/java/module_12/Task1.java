package module_12;
//        Напишіть програму, яка кожну секунду відображає на екрані дані про час, що минув від моменту запуску програми.
//        Другий потік цієї ж програми кожні 5 секунд виводить повідомлення Минуло 5 секунд.
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class Task1 {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Instant startTime = Instant.now();

        executor.scheduleAtFixedRate(() -> {
            Duration elapsed = Duration.between(startTime, Instant.now());
            System.out.println("Час, що минув: " + elapsed.getSeconds() + " секунд");
            //System.out.println("Час: " + System.currentTimeMillis());
        }, 0, 1, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            System.out.println("Минуло 5 секунд");
        }, 5, 5, TimeUnit.SECONDS);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}
