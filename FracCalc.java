package fracCalc;
 import java.util.*;
public class FracCalc {
     public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	System.out.println("Input an equation: ");
    	String equation = input.nextLine();
    	//System.out.println("Printing equation: " + equation);
    	produceAnswer(equation);
     }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	
    	//tests 
    	//System.out.println("Printing input: " + input);
        //System.out.println("Length: " + input.length());

    	
    	//checkpoint 1 variables
        String fraction1 = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ") + 1),(input.indexOf(" ") + 2));
        String fraction2 = input.substring(input.indexOf(" ") + 3, input.length());
        
        //System.out.println("Printing operator: " + operator);
        //System.out.println("Printing frac 1: " + fraction1);
        //System.out.println("Printing frac 2: " + fraction2);
        
        //checkpoint 2 variables
        int whole1;
        int numer1;
        int denom1; 
        
        int whole2;
        int numer2;
        int denom2; 
        
         return fraction2;
    }
     // TODO: Fill in the space below with any helper methods that you think you will need
    
}
