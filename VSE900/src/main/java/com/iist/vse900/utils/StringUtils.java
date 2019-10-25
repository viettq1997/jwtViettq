package com.iist.vse900.utils;

public class StringUtils {

    /**
     *
     * @param n Length of String
     * @return
     */
    public static String generateRandomString(int n)
    {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);
        int lengthAlphaNumberString = alphaNumericString.length();
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(lengthAlphaNumberString * Math.random());

            sb.append(alphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}
