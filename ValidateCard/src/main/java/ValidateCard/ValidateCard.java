package ValidateCard;

import java.util.Scanner;

public class ValidateCard {
	
    public static void main(String[] args)
    {
    	
    	System.out.println("Please Enter Your Credit Card Number: ");
    	Scanner s = new Scanner(System.in);
    	long L = s.nextLong();
    	
        long number = 1234567890123456L;
        
        System.out.println("Check Digit: " + getDigit(L));
        System.out.println("Reversed : " );
        System.out.println("");
        System.out.println("Sum :" + sumOfOddPlace(L)+sumOfDoubleEvenPlace(L));
        System.out.println(L + " is " + (isValid(L) ? "valid" : "invalid"));
 
    }
 
    public static boolean isValid(long number)
    {
       return (getSize(number) >= 14 &&
               getSize(number) <= 19) &&
               (prefixMatched(number, 4) ||
                prefixMatched(number, 5) ||
                prefixMatched(number, 37) ||
                prefixMatched(number, 6)) &&
              ((sumOfDoubleEvenPlace(number) +
                sumOfOddPlace(number)) % 10 == 0);
    }
 
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
         
        return sum;
    }
 
    public static long getDigit(long l)
    {
        if (l < 9)
            return l;
        return l / 10 + l % 10;
    }
 
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");       
        return sum;
    }

    public static boolean prefixMatched(long number, int d)
    {
        return getPrefix(number, getSize(d)) == d;
    }
 
    public static int getSize(long d)
    {
        String num = d + "";
        return num.length();
    }
 
    public static long getPrefix(long number, int k)
    {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }

}
