package lesson6;

public class Wizard extends Player{

    public Wizard(String nickName, int point) {
        super(nickName, point, "Волшебник");
    }

    @Override
    public void doAction() {
        System.out.printf("%s колдует заклинание %n", nickName);
    }
    public void cast(){
        System.out.printf("Экспонинцально");
    }
}
