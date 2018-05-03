package fileVisitors.visitor;

import fileVisitors.util.MyLogger;

/**
 * This is a Node implementation which sets word *
 *
 * @author Siddhesh Dandekar
 * @version 1.0
 * @since 09-27-2017
 */

public class Helper {

    /**
     * Constructor Function
     */
    public Helper() {
        MyLogger.writeMessage("Helper Constructor ",
                MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * This function takes a string and determines whether it's palindrome or not
     * @param str - input
     * @return - boolean
     */
    public boolean checkPalindrome(String str) {
        String reverse = new StringBuffer(str).reverse().toString();
        if (str.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
