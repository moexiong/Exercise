package com.zsx.test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 局长有N种食物，每种食物有Ai份。
 * 每天局长会吃一份食物，或者买一份食物（即每天只能进行吃或买其中的一种动作），这样过了M天
 * 现在局长想知道M天后第p种食物的份数排名（从大到小，相同算并列，例如3 3 2，则排名为1 1 3）N,M,P<=100,Ai<=1000
 *
 * 输入描述：第一行N M P，第二行N个数Ai，接下来M行，每行A i或者B i分别表示买一份食物i，吃一份食物i
 * 输出描述：一个答案
 */
public class Aiqiyi4 {

    //对食物的操作，买或吃
    private static void operateFood(int[] foods, String[] operation, int[] chozen){
        int i = 0;
        while (i < operation.length){
            if ("A".equals(operation[i]))
                foods[chozen[i] - 1]++;
            else
                foods[chozen[i] - 1]--;
            i++;
        }
    }

    //对已经买吃结束的食物进行排名
    private static int[] rank(int[] array){
        int rank[] = new int[array.length];
        for (int i = 0; i < array.length; i++){
            rank[i] = i;
        }
        int count = 1;
        int r = 1;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    temp = rank[j];
                    rank[j] = rank[j + 1];
                    rank[j + 1] = temp;
                }
            }
        }
        int[] ranks = new int[array.length];
        for (int i = array.length - 1; i > 0; i--){
            if (array[i] > array[i - 1]){
                ranks[rank[i]] = r;
                count++;
                r = count;
            }else {
                ranks[rank[i]] = r;
                count++;
            }
        }
        if (array[0] < array[1])
            ranks[rank[0]] = count;
        else
            ranks[rank[0]] = r;
        return ranks;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] nmp = input.nextLine().trim().split("\\s+");
        int n = 0;
        int m = 0;
        int p = 0;
        if (Pattern.matches("^[0-9]+$", nmp[0]))
            n = Integer.parseInt(nmp[0]);
        if (Pattern.matches("^[0-9]+$", nmp[1]))
            m = Integer.parseInt(nmp[1]);
        if (Pattern.matches("^[0-9]+$", nmp[2]))
            p = Integer.parseInt(nmp[2]);

        String[] food = input.nextLine().trim().split("\\s+");
        int[] foods = new int[n];
        for (int i = 0; i < n; i++){
            if (Pattern.matches("^[0-9]+$", food[i]))
                foods[i] = Integer.parseInt(food[i]);
        }

        String[] operation = new String[m];
        int[] chozen = new int[m];
        int i = 0;
        while (m > i){
            String[] oc = input.nextLine().trim().split("\\s+");
            if (Pattern.matches("^A|B$", oc[0]) && Pattern.matches("^[1-9][0-9]*$", oc[1])){
                if (Integer.parseInt(oc[1]) <= n){
                    operation[i] = oc[0];
                    chozen[i] = Integer.parseInt(oc[1]);
                }
            }
            i++;
        }
        operateFood(foods, operation, chozen);
        int[] rank = rank(foods);
        System.out.println(rank[p - 1]);
    }

}
