package menu;

import java.util.Scanner;

public class Input {
    public static int getInt(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static int getDouble(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static int getInt0_Limit (int limit){
        while(true) {
            try {
                int num = getInt();
                if (num > 0 && num < limit)
                    return num;
                else System.out.print("Îé, ùîñü íå òàê... Ñïğîáóéòå çíîâó: ");
            } catch (NumberFormatException nfe) {
                System.out.print("Îé, ùîñü íå òàê... Ñïğîáóéòå çíîâó: ");
            }
        }
    }


}
