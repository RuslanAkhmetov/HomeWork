package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeExtended {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private static final char DOT_EMPTY = '.';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static char[][] MAP ;
    public static final char HEADER_FIRST_SYMBOL = 'H';
    public static final String SPACE_MAP = " ";
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();
    private static int size;

    private static int winCellAmount;
    private static int turnsCount;

    private static int lastRow;
    private static int lastCol;



    public static void start(){
        do {
            System.out.println("\n\n ИГРА НАЧАЛАСЬ!");
            initGame();
            printMAP();
            playGame();
        } while (isContinueGame());
        endGame();
    }
    private static void initGame() {
        turnsCount = 0;
        //получить размер игрового поля, подобрать победную серию для выбранного поля
        System.out.println("Введите размер игрового поля");
        size = getValidNumberFromScanner(MIN_SIZE, MAX_SIZE);
        switch (size) {
            case 3, 4, 5, 6 : winCellAmount = 3;  //размер 3-6 - > победная серия 3
            case 7, 8, 9, 10 : winCellAmount = 4; //размер 7-10 - > победная серия 4
            default: winCellAmount = 5;           //размер +11 - > победная серия 5
        }
        System.out.println("Необходимо составить линию из " +winCellAmount + " символов X");
        initMAP();
    }


    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить ? Y/N");
        return switch (in.next()){
            case "Y", "yes" -> true;
            default -> false;

        };
    }

    private static void endGame() {
        in.close();
        System.out.println("Ты заходи если что!");
    }


    private static void playGame() {
        while (true) {
            humanTurn();
            printMAP();
            if (checkedEnd(DOT_HUMAN, lastRow, lastCol))
                break;
            aiTurn();
            printMAP();
            if (checkedEnd(DOT_AI, lastRow, lastCol))
                break;
        }
    }

    private static boolean checkedEnd(char symbol, int lastHintRow , int lastHintCol) {
        if (checkWin (symbol, winCellAmount, lastHintRow, lastHintCol)){
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

    private static boolean checkWin(char symbol, int winSymbol, int hintRow, int hintCol) {
        int startRow =  (hintCol - winSymbol - 1 > 0) ? (hintCol - winSymbol - 1) : 0;
        int finRow = (hintCol + winSymbol ) <  size ? (hintCol + winSymbol ) : size;
        int winCell = 0;
        for (int i = startRow ; i < finRow; i++) {                                          //проверяем по линии
            if (MAP[hintRow][i] == symbol)
                winCell ++;
            else
                winCell = 0;
            if (winCell == winSymbol) return true;
        }

        int startCol =  (hintRow - winSymbol - 1 > 0) ? (hintRow - winSymbol - 1) : 0;
        int finCol = (hintRow + winSymbol ) <  size ? (hintRow + winSymbol ) : size;
        winCell = 0;
        for (int i = startCol ; i < finCol; i++) {                                          //проверяем по линии
            if (MAP[i][hintCol] == symbol)
                winCell ++;
            else
                winCell = 0;
            if (winCell == winSymbol) return true;
        }

        winCell = 0;
        for (int i = startRow, j = startCol ; i < finRow && j < finCol ; i++, j++) {      //проверяем по левой диагонали
            if (MAP[i][j] == symbol)
                winCell ++;
            else
                winCell = 0;
            if (winCell == winSymbol) return true;
        }

        winCell = 0;
        for (int i = startRow, j = finCol-1 ; i < finRow && j >= startCol  ; i++, j--) {      //проверяем по правой диагонали
            if (MAP[i][j] == symbol)
                winCell ++;
            else
                winCell = 0;
            if (winCell == winSymbol) return true;
        }

       /* if(MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) return true;
        if(MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) return true;
        if(MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) return true;
        if(MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) return true;
        if(MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[2][0] == symbol && MAP[1][1] == symbol && MAP[0][2] == symbol) return true;*/
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

        return turnsCount >= size * size;
    }


    private static void aiTurn() {
        System.out.println("ХОД КОМПЬЮТЕРА");
        do{
            lastRow = random.nextInt(size);
            lastCol = random.nextInt(size);
        }while (!isCellValid(lastRow, lastCol));
        MAP[lastRow][lastCol] = DOT_AI;
        turnsCount ++;
    }

    private static void humanTurn() {
        System.out.println("ХОД ЧЕЛОВЕКА");

        while (true) {
            System.out.print("ВВЕДИТЕ КООРДИНАТЫ СТРОКИ: ");
            lastRow = getValidNumberFromScanner(1, size) - 1;
            System.out.print("ВВЕДИТЕ КООРДИНАТЫ КОЛОНКИ: ");
            lastCol = getValidNumberFromScanner(1, size) - 1;
            if (isCellValid(lastRow, lastCol)) {
                break;
            }
            System.out.printf("ОШИБКА! ПОЛЕ С КООРДИНАТАМИ %s И %S ЗАНЯТО %n", lastRow+1, lastCol+1);
        }
        MAP[lastRow][lastCol] = DOT_HUMAN;
        turnsCount ++;
    }

    private static int getValidNumberFromScanner(int min, int max) {
        while (true){
            if(in.hasNextInt()){
                int n = in.nextInt();
                if (isNumberValued(n, min, max)){
                    return n;
                }
                System.out.println("Проверьте значение координаты. Допускается от " + min + " до " + max );
            } else {
                System.out.println("Ошибка! Ввод допускает лишь целые числа");
                in.next();
            }
        }
    }

    private static boolean isNumberValued(int n, int min, int max) {
        return n >= min && n <= max;
    }

    private static boolean isCellValid(int rowNumber, int colNumber) {
        if (rowNumber < 0 || rowNumber >= size || colNumber < 0 || colNumber >= size) return false;
        return MAP[rowNumber][colNumber] == DOT_EMPTY;
    }

    private static void printMAP() {
        printMAPHeader();
        printMAPBody();
    }

    private static void printMAPHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < size; i++) {
            printMAPNumber(i);
        }
        System.out.println();
    }

    private static void printMAPBody() {
        for (int i = 0; i < size; i++) {
            printMAPNumber(i);

            for (int j = 0; j < size; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();

        }
    }

    private static void printMAPNumber(int i) {
        System.out.print((i + 1) + SPACE_MAP);
    }

    private static void initMAP() {
        MAP = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }
}

