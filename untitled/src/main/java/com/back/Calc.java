package com.back;

public class Calc {
    public static int run(String s) {
        String[] arr = s.split(" ");

        int result = Integer.parseInt(arr[0]);

        for(int i = 1; i < arr.length; i+=2){
            String aa = arr[i];
            int num = Integer.parseInt(arr[i + 1]);

            if(aa.equals("+")) {
                result += num;
            } else if(aa.equals("-")) {
                result -= num;
            } else if(aa.equals("*")) {
                result *= num;
            }
        }
        return result;
    }
}
