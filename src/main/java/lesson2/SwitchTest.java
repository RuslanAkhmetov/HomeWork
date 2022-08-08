package lesson2;

public class SwitchTest {
    public static void main(String[] args) {
        final int SEASON_NUMBER = 1;
        convertSeasonSwitch(SEASON_NUMBER);
        convertSeasonSwitchToMonth(10);
    }

    private static void convertSeasonSwitchToMonth(int month) {
        String season = switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Fall";
            default -> "Unknown season";
        };
        System.out.println(season);
    }

    private static void convertSeasonSwitch(int seasonNumber) {
        String season = switch (seasonNumber) {
            case 1 -> "Winter";
            case 2 -> "Spring";
            case 3 -> "Summer";
            case 4 -> "Fall";
            default -> "Unknown season";
        };
        /*     switch (seasonNumber) {
            case 1:
                season = "Winter";
                break;
            case 2:
                season = "Spring";
                break;
            case 3:
                season = "Summer";
                break;
            case 4:
                season = "Fall";
                break;
            default:
                season = "Unknow season";
        }*/

        System.out.println(season);

    }
}
