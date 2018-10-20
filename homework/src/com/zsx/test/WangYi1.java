package com.zsx.test;

import java.util.*;

public class WangYi1 {

    //row0:facility value   row1:reward
    private int[][] facilityValues;

    private void init(){
        Scanner input = new Scanner(System.in);
        String workAndFriend = input.nextLine();
        //works
        int n = Integer.parseInt(workAndFriend.trim().split("\\s+")[0]);
        facilityValues = new int[2][n];
        for (int i = 0; i < n; i++){
            String work = input.nextLine();
            String[] workInfo = work.split("\\s+");
            facilityValues[0][i] = Integer.parseInt(workInfo[0]);
            facilityValues[1][i] = Integer.parseInt(workInfo[1]);
        }
        String friend = input.nextLine();
        String[] friends = friend.trim().split("\\s+");
        int[] out = new int[friends.length];
        for (int i = 0; i < friends.length; i++){
            //ok
            List<Integer> afford = this.canAfford(facilityValues, Integer.parseInt(friends[i]));
            //max reward
            out[i] = this.maxReward(facilityValues, afford);
        }
        System.out.println(Arrays.toString(out));
    }

    //select the values that what the friend can afford
    private List<Integer> canAfford(int[][] works, int ability){
        List<Integer> afford = new ArrayList<>();
        for (int i = 0; i < works[0].length; i++){
            if (ability >= works[0][i]) afford.add(i);
        }
        return afford;
    }

    //find the max reward
    private int maxReward(int[][] works, List<Integer> afford){
        int max = 0;
        for (int i = 0; i < afford.size(); i++){
            if (works[1][afford.get(i)] > max) max = works[1][afford.get(i)];
        }
        return max;
    }

    public static void main(String[] args){
        WangYi1 t = new WangYi1();
        t.init();
    }

}
