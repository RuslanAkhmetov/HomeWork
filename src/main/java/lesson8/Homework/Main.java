package lesson8.Homework;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        JumpAndRun[] part = new JumpAndRun[10];

        for (int i = 0; i <10; i++) {
            switch (ThreadLocalRandom.current().nextInt(3)) {
                case 0:
                    part[i] = new Person("Человек " + i, (float)(1.0 + 0.1 * i),1000 + 100 *i);
                    break;
                case 1:
                    part[i] = new Horse("Конь " + i, (float)(2.0 + i * 0.1), 10000 + 1000 * i);
                    break;
                case 2:
                    part[i] = new Robot("Робот " + i, (float)(1.0 + 0.1 * i), 1000 + 100 * i);
                default:
                    part[i] = new Robot("Робот " + i, (float)(1.0 + 0.1 * i), 1000 + 100 * i);

            }
        }
        Barrier[] barrier = new Barrier[8];
        /*Wall[] walls =  new Wall[4];
        RaceTrack[] raceTracks = new RaceTrack[4];*/
        for (int i = 0; i < barrier.length; i += 2) {
            barrier[i] = new Wall("Стена " + i, (float)(0.8 + 0.1 * i));
            barrier[i+1] = new RaceTrack("Дорожка " + i, (1000 + 200 * i));
        }
        for (int i = 0; i < part.length; i++) {
            for (int j = 0; j <barrier.length; j++) {
               barrier[j].printInfo();
               if (!barrier[j].stepOver( part[i])) {
                   break;
               }
            }
        }

    }
}
