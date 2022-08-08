package lesson5;

public class Player {
    private String nickName;
    private int point;
    private int level;
    private int money;
    private static int  countPlayers;

    public Player(String nickName, int point, int level, int money) {
        this.nickName = nickName;
        this.point = point;
        this.level = level;
        setMoney(money);
        countPlayers++;
    }

    public Player(String nickName) {
        this(nickName, 0, 1, 100);
    }

    void printInfo(){
        System.out.println(String.format(" Player %s ( lvl %d ) has %d point and %d money", nickName, level, point, money));
    }

    public String toString(){
        return String.format(" (SOUT) Player %s ( lvl %d ) has %d point and %d money",  nickName, level, point, money);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0)
            this.money = 0;
        else
            this.money = money;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
