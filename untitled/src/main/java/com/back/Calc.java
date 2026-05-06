package com.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    public static int run(String s) {
        // 괄호 연산 처리
        while (s.contains("(")) {
            int start = s.lastIndexOf("(");
            int end = s.indexOf(')', start);

            String str = s.substring(start + 1, end);

            int value = calculate(str);

            s = s.substring(0, start) + value + s.substring(end + 1);
        }
        return calculate(s);
    }

    private static int calculate(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));

        // 곱셈/나눗셈 계산 먼저
        for(int i = 1; i < list.size() - 1; i += 2) {
            String str = list.get(i);

            if(str.equals("*") || str.equals("/")) {
                int num1 = Integer.parseInt(list.get(i - 1));
                int num2 = Integer.parseInt(list.get(i + 1));

                int result = (str.equals("*") ? num1 * num2 : num1 / num2);

                // 해당 연산 기준 앞 뒤 리스트 제거
                list.remove(i + 1);
                list.remove(i);
                list.remove(i - 1);

                // 제거 후 그 자리에 연산한 result 값 넣기
                list.add(i - 1, String.valueOf(result));

                // 인덱스는 연산앞자리
                i -= 2;
            }
        }

        // 덧셈/뺄셈 처리
        int result = Integer.parseInt(list.get(0));

        for(int i = 1; i < list.size(); i+=2){
            String aa = list.get(i);
            int num = Integer.parseInt(list.get(i + 1));

            if(aa.equals("+")) {
                result += num;
            } else if(aa.equals("-")) {
                result -= num;
            }
        }
        return result;
    }
}

