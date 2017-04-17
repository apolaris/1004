//*********************************
//
//Beichen Zhang, bz2309
//2/20/2017
//
//FactorPrinter class
//
//This class tests your FactorGenerator class.
//
//Do not alter this class. The FactorGenerator
//class that you write must work with this class.
//*********************************

import java.util.Scanner;

public class FactorPrinter{

  public static void main(String[] args){

      // get input from the user
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a number to be factored");
      int n = input.nextInt();

      // create a FactorGenerator object
      FactorGenerator factor = new FactorGenerator(n);


      // now print out the factors
      System.out.println("The factors are: ");
      while (factor.hasMoreFactors()){
          System.out.println(factor.nextFactor());
      }

  }

}

