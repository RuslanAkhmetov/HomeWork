package lesson8.Homework;

public class Competition {
    JumpAndRun[] part;
    Barrier[] barrier;

    public Competition(JumpAndRun[] part, Barrier[] barriers) {
        this.part = part;
        this.barrier = barriers;
    }

    public void start(){
        for (int i = 0; i < part.length; i++)
            for (int j = 0; j < barrier.length; j++) {
                barrier[j].printInfo();
                if (!barrier[j].stepOver(part[i])) {
                    break;
                }
            }
    }
}
