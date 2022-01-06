import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        WhackAMole whack = new WhackAMole(50, 10);
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nWelcome to Whack A Mole! You have " + whack.attemptsLeft + " attempts to whack all moles. At any time you can enter -1 and -1 to exit game.\n");
        while(whack.attemptsLeft > 0) {
            System.out.println("Enter first x coordenate then y coordenate to whack:");
            int x = myObj.nextInt();
            int y = myObj.nextInt();
            if(x == -1 && y == -1) {
                whack.printGrid();
                break ;
            }
            whack.whack(x, y);
            whack.printGridToUser();
        }
    }
}