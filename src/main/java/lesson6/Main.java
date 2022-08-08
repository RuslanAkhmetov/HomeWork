package lesson6;

public class Main {
    public static void main(String[] args) {

        Wizard wizard = new Wizard("Roman", 1000);
        Knight knight = new Knight("Olga", 300, "Экскалибур");
        Player knight2 = new Knight("Mark", 120, "Меч кладенец");
 /*       System.out.println(wizard);
        System.out.println(knight);
        wizard.doAction();
        knight.doAction();
        knight.saddleHorse();
        knight2.doAction();
        wizard.printinfo();
        knight.printinfo();
        knight2.printinfo();*/
        Player[] players = {wizard, knight, knight2};
        for (Player player: players
             ) {
            player.printinfo();
            player.doAction();
           /* if (player instanceof Wizard) {
                Wizard w = (Wizard) player;
                w.cast();
            }*/
            if (player instanceof Wizard w){
                w.cast();
            }
        }
    }
    public static void test(Player player){
        player.doAction();
    }
}
