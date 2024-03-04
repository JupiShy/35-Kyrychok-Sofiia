package practicapplication;

import Task2_1.*;
import java.util.Scanner;
/**
 *
 * @author Киричок Софія
 */
public class PracticApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//      Task 1 Test
        
        System.out.println("Task 1\nEnter something in console: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Your input: " + input);
        
//      Task 2 #1 Test
        
        System.out.println("Task 2.1");
        Parameters params = new Parameters(15, 2);
        Calculating calc = new Calculating(params);
        calc.calculate();
        String str = params.toString();
        System.out.println(str);
    }
}
