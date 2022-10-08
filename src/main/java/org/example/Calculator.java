package org.example;

// Importing libraries
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Iterator;

public class Calculator
{

    public static ArrayList<String> bodmas(String digits)
    {
        ArrayList<String> newSum = new ArrayList<>();                    // Creating array list for all digits
        StringTokenizer token = new StringTokenizer(digits, " ");

        Iterator<Object> count = token.asIterator();
        while (count.hasNext())
        {
            newSum.add((String) count.next());
        }

        if (newSum.contains("*"))     // Creating a fix for multiplication which will have repeated methods for both
        // subtraction and addition
        {
            do
            {
                int addOne = Integer.parseInt(newSum.get(newSum.indexOf("*") + 1));
                int addTwo = Integer.parseInt(newSum.get(newSum.indexOf("*") - 1));

                int solution = addTwo * addOne;

                newSum.set(newSum.indexOf("*") - 1, Integer.toString(solution));
                newSum.remove(newSum.indexOf("*") + 1);
                newSum.remove(newSum.indexOf("*"));
            } while (newSum.contains("*"));
        }

        if (newSum.contains("-"))
        {
            do
            {
                int addOne = Integer.parseInt(newSum.get(newSum.indexOf("-") + 1));
                int addTwo = Integer.parseInt(newSum.get(newSum.indexOf("-") - 1));

                int solution = addTwo - addOne;

                newSum.set(newSum.indexOf("-") - 1, Integer.toString(solution));
                newSum.remove(newSum.indexOf("-") + 1);
                newSum.remove(newSum.indexOf("-"));
            } while (newSum.contains("-"));
        }

        if (newSum.contains("+"))
        {
            do
            {
                int addOne = Integer.parseInt(newSum.get(newSum.indexOf("+") + 1));
                int addTwo = Integer.parseInt(newSum.get(newSum.indexOf("+") - 1));

                int solution = addTwo + addOne;

                newSum.set(newSum.indexOf("+") - 1, Integer.toString(solution));
                newSum.remove(newSum.indexOf("+") + 1);
                newSum.remove(newSum.indexOf("+"));
            } while (newSum.contains("+"));
        }
    /*  else if(newSum.equals("++"))
        {
                System.out.println("Invalid pls type in your equation again:");
        } */

        return newSum;
    }

    public static void main(String[] args)
    {
        System.out.println("Pls type in your equation:");
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();

        for(String digit : bodmas(num))   // Equation will be solved for the user
        {
            System.out.println(digit);

         /*  if(digit.equalsIgnoreCase( "++")|| digit.equalsIgnoreCase("--")|| digit.equalsIgnoreCase("**"))
            {
                System.out.println("Invalid pls type in your equation again:");
            }
            else
            {
                break;
            }*/
        }
    }

    // Test 12435 + 34569 - 12345 * 10 + 50
}
