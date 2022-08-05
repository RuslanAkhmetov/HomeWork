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

        Wall[] walls =  new Wall[4];
        RaceTrack[] raceTracks = new RaceTrack[4];
        for (int i = 0; i < 4; i++) {
            walls[i] = new Wall("Стена " + i, (float)(0.8 + 0.1 * i));
            raceTracks[i] = new RaceTrack("Дорожка " + i, (1000 + 200 * i));
        }
        for (int i = 0; i < part.length; i++) {
            for (int j = 0; j < walls.length && j < raceTracks.length; j++) {
               System.out.print(walls[j].getName() + " высота " + walls[j].getHeight() + ": ");
               if (!walls[j].jumpOver( part[i]))
                   break;
                System.out.print(raceTracks[j].getName() + " дистанция " + raceTracks[j].getDistance() + ": ");
                if (!raceTracks[j].runDistance( part[i])) {
                   break;
               }
            }
        }
        /*Person person = new Person("Федор", 1.5F, 21200);
        Horse horse = new Horse("Конь", 2.5F, 60000L);
        Wall wall = new Wall("Препятствие 1", 2.0F);*/
       /* System.out.print(wall.getName() + " высота " + wall.getHeight());
        wall.jumpOver(person);
        System.out.print(raceTrack.getName() + " дистанция " + raceTrack.getDistance());
        raceTrack.runDistance(person);
        System.out.print(wall.getName() + " высота " + wall.getHeight());
        wall.jumpOver(horse);
        System.out.print(raceTrack.getName() + " дистанция " + raceTrack.getDistance());
        raceTrack.runDistance(horse);*/
    }
}
