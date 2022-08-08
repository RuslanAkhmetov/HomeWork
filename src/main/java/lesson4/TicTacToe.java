package lesson4;

import java.util.Random;
import java.util.Scanner;

//import static sun.tools.jconsole.OutputViewer.init;

public class TicTacToe {
    private static final int SIZE = 3;
    private static final char DOT_EMPTY = '.';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char[][] MAP = new char[SIZE][SIZE];
    public static final char HEADER_FIRST_SYMBOL = 'H';
    public static final String SPACE_MAP = " ";
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();
    private static int turnsCount;

    private static int lastRow;
    private static int lastCol;



    public static void main(String[] args) {
        initMAP();
        printMAP();
        playGame();

    }






    private static void playGame() {
        while (true) {
            humanTurn();
            printMAP();
            if (checkedEnd(DOT_HUMAN))
                break;
            aiTurn();
            printMAP();
            if (checkedEnd(DOT_AI))
                break;
        }
    }

    private static boolean checkedEnd(char symbol) {
        if (checkWin (symbol)){
            if (symbol == DOT_HUMAN)
                System.out.println(" УРА ВЫ ПОБЕДИЛИ");
            else
                System.out.println("Восстание близка ... ИИ победил");
            return true;
        };
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {
        if(MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) return true;
        if(MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) return true;
        if(MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) return true;
        if(MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) return true;
        if(MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[2][0] == symbol && MAP[1][1] == symbol && MAP[0][2] == symbol) return true;
        return false;
        
    }

    private static boolean checkDraw() {
  /*      for (char[] chars : MAP){
            for (char symbol : MAP[chars]){
                if (symbol == DOT_EMPTY) {
                    return false;
                   }
                }
        }
        return true;*/

        return turnsCount >= SIZE * SIZE;
    }


    private static void aiTurn() {
        System.out.println("ХОД КОМПЬЮТЕРА");
        do{
            lastRow = random.nextInt(SIZE);
            lastCol = random.nextInt(SIZE);
        }while (!isCellValid(lastRow, lastCol));
        MAP[lastRow][lastCol] = DOT_AI;
        turnsCount ++;
    }

    private static void humanTurn() {
        System.out.println("ХОД ЧЕЛОВЕКА");

        while (true) {
            System.out.print("ВВЕДИТЕ КООРДИНАТЫ СТРОКИ: ");
            lastRow = in.nextInt() - 1;
            System.out.print("ВВЕДИТЕ КООРДИНАТЫ КОЛОНКИ: ");
            lastCol = in.nextInt() - 1;
            if (isCellValid(lastRow, lastCol)) {
                break;
            }
            System.out.printf("ОШИБКА! ПОЛЕ С КООРДИНАТАМИ %s И %S ЗАНЯТО %n", lastRow+1, lastCol+1);
        }
        MAP[lastRow][lastCol] = DOT_HUMAN;
        turnsCount ++;
    }

    private static boolean isCellValid(int rowNumber, int colNumber) {
        if (rowNumber < 0 || rowNumber >= SIZE || colNumber < 0 || colNumber >= SIZE) return false;
        return MAP[rowNumber][colNumber] == DOT_EMPTY;
    }

    private static void printMAP() {
        printMAPHeader();
        printMAPBody();
    }

    private static void printMAPHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMAPNumber(i);
        }
        System.out.println();
    }

    private static void printMAPBody() {
        for (int i = 0; i < SIZE; i++) {
            printMAPNumber(i);

            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();

        }
    }

    private static void printMAPNumber(int i) {
        System.out.print((i + 1) + SPACE_MAP);
    }

    private static void initMAP() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }
}

