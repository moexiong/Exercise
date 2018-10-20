package com.zsx.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 数列的定义如下： 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 *
 * 输入描述：输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 * 输出描述：对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 */
public class Aiqiyi1 {

    private static class Number{
        double number;
        int length;
    }

    private static List<Double> answers = new ArrayList<>();

    private static double s = 0;

    private static void find(List<Number> numbers){
        for (Number number : numbers) {
            s += number.number;
            sum(number.number, number.length);
            double an = s;
            answers.add(an);
            s = 0;
        }
    }

    private static void sum(double number, int length){
        if (length > 1){
            double temp = ((int)(Math.sqrt(number) * 100)) / 100.0;
            s += temp;
            sum(temp, length - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Number> numbers = new ArrayList<>();
        while (input.hasNextLine()){
            String string = input.nextLine();
            String reg = "^\\d+\\s+\\d$";
            if (Pattern.matches(reg, string)){
                Number number = new Number();
                String[] arr = string.split("\\s+");
                number.number = Double.parseDouble(arr[0]);
                number.length = Integer.parseInt(arr[1]);
                numbers.add(number);
            }else if ("".equals(string)){
                break;
            }
        }
        find(numbers);
        answers.forEach(System.out::println);
        input.close();
    }
}
