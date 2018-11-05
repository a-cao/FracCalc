package fracCalc;
 import java.util.*;
public class FracCalc {
     public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	System.out.println("Input an equation, or type 'quit' to quit: ");
    	String equation = input.nextLine();
    	//System.out.println("Printing equation: " + equation);
    	while (!(equation.equals("quit"))) {
    		produceAnswer(equation);
    		System.out.println("Input an equation, or type 'quit' to quit: ");
    		equation = input.nextLine();
    	}    	
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
    	
    	//input tests 
    	//System.out.println("Printing input: " + input);
        //System.out.println("Length: " + input.length());

    	
    	//checkpoint 1 variables + assignment
        String fraction1 = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ") + 1),(input.indexOf(" ") + 2));
        String fraction2 = input.substring(input.indexOf(" ") + 3, input.length());
        
        //checkpoint 1 tests
        //System.out.println("Printing operator: " + operator);
        //System.out.println("Printing frac 1: " + fraction1);
        //System.out.println("Printing frac 2: " + fraction2);
        
        //checkpoint 2 variables
        int whole1 = 0;
        int numer1 = 0;
        int denom1 = 0; 
        
        int whole2 = 0;
        int numer2 = 0;
        int denom2 = 0; 
        
        //checkpoint 2 variable assignment
        if (fraction1.contains("_")) {
            whole1 = Integer.parseInt(fraction1.substring(0, fraction1.indexOf("_")));            
            numer1 = Integer.parseInt(fraction1.substring((fraction1.indexOf("_") + 1), fraction1.indexOf("/")));
            denom1 = Integer.parseInt(fraction1.substring((fraction1.indexOf("/") + 1), fraction1.length()));
            
        } else if (!(fraction1.contains("/"))){
        	whole1 = Integer.parseInt(fraction1);
        	numer1 = 0;
        	denom1 = 1;
        } else {
        	whole1 = 0;
        	numer1 = Integer.parseInt(fraction1.substring(0, fraction1.indexOf("/")));
            denom1 = Integer.parseInt(fraction1.substring((fraction1.indexOf("/") + 1), fraction1.length()));
        }
        
        if (fraction2.contains("_")) {
            whole2 = Integer.parseInt(fraction2.substring(0, fraction2.indexOf("_")));            
            numer2 = Integer.parseInt(fraction2.substring((fraction2.indexOf("_") + 1), fraction2.indexOf("/")));
            denom2 = Integer.parseInt(fraction2.substring((fraction2.indexOf("/") + 1), fraction2.length()));
            
        } else if (!(fraction2.contains("/"))){
        	whole2 = Integer.parseInt(fraction2);
        	numer2 = 0;
        	denom2 = 1;
        } else {
        	whole2 = 0;
        	numer2 = Integer.parseInt(fraction2.substring(0, fraction2.indexOf("/")));
            denom2 = Integer.parseInt(fraction2.substring((fraction2.indexOf("/") + 1), fraction2.length()));
        }
        
        //checkpoint 2 tests
        /*System.out.println("Printing whole1: " + whole1);
        System.out.println("Printing numer1: " + numer1);
        System.out.println("Printing denom1: " + denom1);                
        System.out.println("Printing whole2: " + whole2);
        System.out.println("Printing numer2: " + numer2);
        System.out.println("Printing denom2: " + denom2);*/
        
         //return fraction2;
        return ("whole:" + whole2 + " numerator:" + numer2 + " denominator:" + denom2);
    }
     // TODO: Fill in the space below with any helper methods that you think you will need
    
}
