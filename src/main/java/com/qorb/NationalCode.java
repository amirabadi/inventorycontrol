package com.qorb;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by amirabadi-h on 04/07/2018.
 */
public class NationalCode {
    public static Boolean isValidNationalCode(String nationalCode)
    {

        ArrayList<String> allDigitEqual=new ArrayList<>();
        allDigitEqual.addAll(Arrays.asList("0000000000", "1111111111", "2222222222", "3333333333", "4444444444", "5555555555", "6666666666", "7777777777", "8888888888", "9999999999" ));
        if (allDigitEqual.contains(nationalCode)) return false;
        if (nationalCode.length() != 10)
        {
            return false;
        }
        else
        {
            char[] chArray = nationalCode.toCharArray();
            int num0 = Integer.valueOf(String.valueOf(chArray[0])) * 10;
            int num2 = Integer.valueOf(String.valueOf(chArray[1])) * 9;
            int num3 = Integer.valueOf(String.valueOf(chArray[2])) * 8;
            int num4 = Integer.valueOf(String.valueOf(chArray[3])) * 7;
            int num5 = Integer.valueOf(String.valueOf(chArray[4])) * 6;
            int num6 = Integer.valueOf(String.valueOf(chArray[5])) * 5;
            int num7 = Integer.valueOf(String.valueOf(chArray[6])) * 4;
            int num8 = Integer.valueOf(String.valueOf(chArray[7])) * 3;
            int num9 = Integer.valueOf(String.valueOf(chArray[8])) * 2;
            int a = Integer.valueOf(String.valueOf(chArray[9]));

            int b = (((((((num0 + num2) + num3) + num4) + num5) + num6) + num7) + num8) + num9;
            int c = b % 11;
            return (((c < 2) && (a == c)) || ((c >= 2) && ((11 - c) == a)));
        }
    }
}
