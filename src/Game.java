
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)) {
            System.out.print("Enter The Game Row :");
            int rows = input.nextInt();
            System.out.print("Enter The Game Column : ");
            int columns = input.nextInt();

            Minesweeper mine = new Minesweeper(rows,columns);
            mine.play();
        }
    }
}
