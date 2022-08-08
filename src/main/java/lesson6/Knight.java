package lesson6;

public class Knight extends Player{
    private String swordTitle;

    public Knight(String nickName, int point, String swordTitle) {
        super(nickName, point, "Рыцарь");
        this.swordTitle = swordTitle;
    }

    public String getSwordTitle() {
        return swordTitle;
    }

    public void setSwordTitle(String swordTitle) {
        this.swordTitle = swordTitle;
    }

    public void saddleHorse(){

        System.out.println("Вперед лошадь!");
    }

    @Override
    public void doAction() {
        System.out.printf("%s машет мячом %s %n", nickName, swordTitle );
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" and has sword %s %n", swordTitle);
    }
}
