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

         
         //checkpoint 1 variables + assignment
         String fraction1 = input.substring(0, input.indexOf(" "));
         String operator = input.substring((input.indexOf(" ") + 1),(input.indexOf(" ") + 2));
         String fraction2 = input.substring(input.indexOf(" ") + 3, input.length());
         
         //checkpoint 2 variables
         int whole1 = setWhole(fraction1);
         int numer1 = setNumer(fraction1);
         int denom1 = setDenom(fraction1); 

         int whole2 = setWhole(fraction2);
         int numer2 = setNumer(fraction2);
         int denom2 = setDenom(fraction2);
         
         //checkpoint 3
         //checkpoint 3 variable declaration
         //note, the code doesn't run if the ans vars aren't initialized
         int wholeAns = 0;
         int numerAns = 0;
         int denomAns = 1;
         
         //checkpoint 3 variable assignment 
         //making everything an improper fraction
         if (whole1 != 0) {
        	 if (whole1 < 0) {
        		 numer1 = numer1*-1 + whole1*denom1;
        	 } else {
        		 numer1 += whole1*denom1;
        	 }
        	 whole1 = 0;       	 
         }
         
         if (whole2 != 0) {
        	 if (whole2 < 0) {
        		 numer2 = numer2*-1 + whole2*denom2;
        	 } else {
        		 numer2 += whole2*denom2;
        	 }
        	 whole2 = 0;       	 
         }
         //addition/subtraction
         if (operator.equals("+") || operator.equals("-")) {
        	 //setting denom as lcm for both fractions
             if (denom1 != denom2) {
            	 int tempLCM = lcm(denom1, denom2);
            	 numer1 *= tempLCM/denom1;
            	 denom1 = tempLCM;
            	 numer2 *= tempLCM/denom2;
            	 denom2 = tempLCM;
             }
             denomAns = denom1;
             if (operator.equals("+")) {
            	 numerAns = numer1 + numer2;
             } else {
            	 numerAns = numer1 - numer2;
             }
         //multiplication/division
         } else if (operator.equals("*") || operator.equals("/")) {
        	 if (operator.equals("*")) {
        		 numerAns = numer1*numer2;
        		 denomAns = denom1*denom2;
        	 } else {
        		 numerAns = numer1*denom2;
        		 denomAns = denom1*numer2;
        	 }
         }
         //simplifying ans
         //gcf division
         int tempGCF = gcf(numerAns, denomAns);
         numerAns = numerAns/tempGCF;
         denomAns = denomAns/tempGCF;
         //making into mixed number
         if (numerAns > denomAns) {
        	 wholeAns = (numerAns/denomAns);
        	 numerAns = numerAns - wholeAns*denomAns;
         } else if (numerAns == denomAns) {
        	 wholeAns = 1;
        	 numerAns = 0;
         }
         //making sure denom isn't negative
         if (denomAns < 0) {
        	 denomAns *= -1;
         }
         	return (wholeAns + "_" + numerAns + "/" + denomAns);
     }
      // TODO: Fill in the space below with any helper methods that you think you will need
     //finds gfc of two given ints, returns as int
     public static int gcf(int a, int b) {
    	    if (b == 0) {
    	      return a;
    	    } else {
    	      return (gcf(b, a % b));
    	    }
     }
     //finds lcm of two given ints, returns as int
     public static int lcm(int a, int b){
         int lcm = (a > b) ? a : b;
         for(; lcm <= (a * b) ; lcm++){
             if (lcm % a == 0 && lcm % b == 0) {
                 break;
             }
         }
         return lcm;
     }
     
     //one of three functions that assigns component vals (whole, numer, denom) using an input fraction 
     public static int setWhole(String fraction) {  	 
    	 if (fraction.contains("_")) {
             return Integer.parseInt(fraction.substring(0, fraction.indexOf("_")));                         
         } else if (!(fraction.contains("/"))){
             return Integer.parseInt(fraction);
         } else {
             return 0;
         } 	 
	    }
     
     public static int setNumer(String fraction) {  	 
    	 if (fraction.contains("_")) {
             return Integer.parseInt(fraction.substring((fraction.indexOf("_") + 1), fraction.indexOf("/")));             
         } else if (!(fraction.contains("/"))){
             return 0;
         } else {
             return Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
         } 	 
	    }
     
     public static int setDenom(String fraction) {  	 
    	 if (fraction.contains("_")) {
             return Integer.parseInt(fraction.substring((fraction.indexOf("/") + 1), fraction.length()));            
         } else if (!(fraction.contains("/"))){
             return 1;
         } else {
             return Integer.parseInt(fraction.substring((fraction.indexOf("/") + 1), fraction.length()));
         } 	 
	    }
	 }