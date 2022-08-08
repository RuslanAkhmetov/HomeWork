package lesson5;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alexander", 1000, 57, 200);
        Player player2 = new Player("Anatoliy", 500, 30, 100);
        Player player3 = new Player("Rodion");
/*        player1.nickName = "Timofey";
        player2.nickName = "Kristina";
        System.out.println(player1.nickName);
        System.out.println(player2.nickName);*/
/*        player1.printInfo();
        player2.printInfo();
        player3.printInfo();

        System.out.println(player1.getLevel());
        player1.setLevel(100);
        player3.setNickName("Vadim");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);*/

        Player[] players = new Player[] {player1, player2, player3};
        for (Player p : players ) {
            System.out.println(p);
        }
        System.out.println("Amount of players" + Player.getCountPlayers());
    }
}
