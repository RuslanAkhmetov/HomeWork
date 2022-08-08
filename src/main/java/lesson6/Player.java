package lesson6;

public abstract class  Player{
    protected String nickName;
    private int point;

    private String russianProfession;

    public Player(String nickName, int point, String russianProfession) {
        this.nickName = nickName;
        this.point = point;
        this.russianProfession = russianProfession;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return String.format("%s %s has %d points!", russianProfession, nickName , point);
    }

    public void printinfo(){
        System.out.println(toString());
    }

    public abstract void doAction();
}
