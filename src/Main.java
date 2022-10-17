
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("----------------------------------------------------------------");
        System.out.println("                           MasterMind                           ");
        System.out.println("----------------------------------------------------------------");
        System.out.println();


        int[] computerNumbers = new int[4];
        Random randomNumber = new Random();

        for (int i = 0; i < 4; i++) {
            computerNumbers[i] = randomNumber.nextInt(6) + 1;
            System.out.println(computerNumbers[i]);
        }


        final int NUMBER_LENGTH = 4;
        int[] playerGuess = new int[4];

        Scanner myKeyboard = new Scanner(System.in);

        System.out.println("Wybierz 4 liczby od 1 do 6 (masz 10 prób)");
        System.out.print(" [] - Nie zgadłeś żadnej liczby ");
        System.out.print(" [0] - Liczba znajduje się nie na swoim miejscu ");
        System.out.print(" [1] - Jedna liczba znajduje się na swoim miejscu  ");
        System.out.print(" [11] - Dwie liczby znajdują się na swoim miejscu  ");
        System.out.println(" [111] - Trzy liczby znajdują się na swoim miejscu  ");

        int numberOfTries = 1;

        boolean arraysEqual = false;





        while (!arraysEqual && numberOfTries <= 10) {
            String buffor = myKeyboard.nextLine();
            int[] computer = new int[4];
            int[] player = new int[4];


            for (int i = 0; i < NUMBER_LENGTH; i++) {
                playerGuess[i] = Character.getNumericValue(buffor.charAt(i));
                if ( Character.getNumericValue(buffor.charAt(i)) > 6 || Character.getNumericValue(buffor.charAt(i)) < 1){
                    System.out.println("Wpisz poprawną liczbe od 1 do 6");
                    return;
                }
            }

            System.out.print(" ("+numberOfTries+")  ");
            for (int i = 0; i < NUMBER_LENGTH; i++) {
                System.out.print(playerGuess[i]);
            }
            StringBuilder check = new StringBuilder();

            for (int i = 0; i < playerGuess.length; i++) {
                if (playerGuess[i] == computerNumbers[i]) {
                    player[i] = 1;
                    computer[i] = 1;
                    check.append("1");


                }
            }
            if( check.toString().equals("1111")){
                arraysEqual = true;
                System.out.println(" Wygrałeś zajęło ci to dokładnie " + numberOfTries+ " próbe");
            }else{
                for (int i = 0; i < playerGuess.length; i++){
                    for (int j = 0; j < playerGuess.length;j++ ){
                        if (playerGuess[i] == computerNumbers[j] && player[i] != 1 && computer[j] != 1){
                            player[i] = 1;
                            computer[j]=1;
                            check.append("0");

                        }
                    }
                }
            }
            System.out.println( " ["+check+ "] "  );

            if(numberOfTries == 10){
                System.out.println("Koniec prób, przegrałeś");
            }

            numberOfTries++;



        }


    }

}

















