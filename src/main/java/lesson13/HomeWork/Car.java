package lesson13.HomeWork;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static java.lang.System.currentTimeMillis;

public class Car implements Runnable {
    private static int carNumber;
    private static long startTime=0;

    public static Long getFinishTime() {
        synchronized (finishTime) {
            return finishTime;
        }
    }

    private static Long finishTime= 0L;

    private Race race;
    private int speed;
    private String name;

    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatchFinish;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        carNumber++;
        this.name = "Участник #" + carNumber;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch, CountDownLatch countDownLatchFinish) {
         this(race, speed);
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
        this.countDownLatchFinish = countDownLatchFinish;

    }
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            if (startTime ==0) startTime =  currentTimeMillis();
            countDownLatch.countDown();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (getFinishTime() == 0L) {
                System.out.println("Победитель: " + name);
                finishTime =  currentTimeMillis();
                System.out.println("Время победителя: " + (finishTime - startTime) + " миллисекунд.");
            }
            countDownLatchFinish.countDown();
        }

    }
}
