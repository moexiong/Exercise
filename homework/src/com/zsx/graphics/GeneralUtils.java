package com.zsx.graphics;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 生成图的工具类
 */
public class GeneralUtils {

    //生成指定节点数量的图
    protected static int[][] GenerateGraphic(){
        Scanner input = new Scanner(System.in);
        int number = getNumber(input);
        int[][] matrix = getMatrix(input, number);
        input.close();
        return matrix;
    }

    //得到图的节点数量
    private static int getNumber(Scanner input){
        boolean flag = true;
        while (true){
            if (flag)
                System.out.println("示例输入：6");
            flag = false;
            System.out.print("请输入图的节点数量：");
            String string = input.nextLine().trim();
            String reg = "^\\d+$";
            if (Pattern.matches(reg, string)){
                return Integer.parseInt(string);
            }else
                System.out.println("输入有误！");
        }
    }

    //得到节点的权值矩阵
    private static int[][] getMatrix(Scanner input, int number){
        boolean flag = true;
        int[][] matrix = new int[number][number];
        int i = 0;
        while (i < number){
            if (flag){
                System.out.println("6个节点时示例输入：");
                System.out.println("0 6 1 5 N N");
                System.out.println("6 0 5 N 3 N");
                System.out.println("1 5 0 5 6 4");
                System.out.println("5 N 5 0 N 2");
                System.out.println("N 3 6 N 0 6");
                System.out.println("N N 4 2 6 0");
            }
            flag = false;
            System.out.println("请依次输入节点的权值：");
            String string = input.nextLine().trim();
            String[] strings = string.split("\\s+");
            int[] line = changeStrsToInts(strings);
            if (null != line){
                for (int j = 0; j < line.length; j++){
                    matrix[i][j] = line[j];
                }
                i++;
            }else
                System.out.println("输入有误！");
        }
        return matrix;
    }

    //将字符串数组转换为数字数组
    private static int[] changeStrsToInts(String[] strings){
        String reg = "^[\\d+|N]$";
        int[] values = new int[strings.length];
        for (int i = 0; i < strings.length; i++){
            if (Pattern.matches(reg, strings[i]))
                values[i] = Integer.parseInt(strings[i]);
            else
                return null;
        }
        return values;
    }
}
