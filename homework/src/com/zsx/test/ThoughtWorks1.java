package com.zsx.test;

import java.util.Scanner;

public class ThoughtWorks1 {

    //存放迷宫的数组
    private int[][] maze;

    //初始化，接受输入
    public void init(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("如果给定输入:");
            String inputMaze = input.nextLine();
            String flag = this.isMazeOk(inputMaze);
            if ("ok".equals(flag)){
                while (true){
                    //System.out.println("请输入设置迷宫:");
                    String inputLocation = input.nextLine();
                    flag = this.isLocationOk(inputLocation);
                    if ("ok".equals(flag)){
                        //接收3
                        while (true){
                            String robot = input.nextLine();
                            String robotIn = this.isRobotIn(robot);
                            if ("go".equals(robotIn)){
                                System.out.println("则输出字符串为（如果当前 渲染网格 为墙壁，则输出为[W] 如果为道路，则输出为[R]）：");
                                this.printMaze();
                                input.close();
                                return;
                            }else if (!robotIn.contains("\\s")){
                                //机器人开始行动了
                                this.robotMove(robotIn);
                            }else {
                                System.out.println(robotIn);
                            }
                        }
                    }else {
                        System.out.println(flag);
                        //重新初始化迷宫
                        for (int i = 0; i < this.maze.length; i++) {
                            for (int j = 0; j < this.maze[i].length; j++){
                                this.maze[i][j] = 0;
                            }
                        }
                    }
                }
            }else {
                System.out.println(flag);
            }
        }
    }

    //判断输入的迷宫是否合理并给迷宫设置大小
    private String isMazeOk(String inputMaze){
        try {
            String[] in = inputMaze.trim().split("\\s+");
            if (in.length != 2){
                return "Incorrect command format!";
            }else {
                int m = Integer.parseInt(in[0]);
                int n = Integer.parseInt(in[1]);
                if (m <= 0 || n <= 0){
                    return "Number out of range!";
                }else {
                    //初始化迷宫 0表示墙 1表示道路
                    this.maze = new int[2 * m + 1][2 * n + 1];
                    for (int i = 0; i < this.maze.length; i++) {
                        for (int j = 0; j < this.maze[i].length; j++){
                            this.maze[i][j] = 0;
                        }
                    }
                }
            }
        }catch (Exception e){
            return "Invalid number format!";
        }
        return "ok";
    }

    //判断输入的坐标是否合理并进行拆分
    private String isLocationOk(String inputLocation){
        String[] in = inputLocation.trim().split(";");
        for (int i = 0; i < in.length; i++) {
            String[] locations = in[i].trim().split("\\s+");
            if (locations.length != 2){
                return "Incorrect command format!";
            }else {
                String flag = this.isAssociateOk(locations);
                if (!"ok".equals(flag)){
                    return flag;
                }
            }
        }
        return "ok";
    }

    //判断输入的坐标是否合理并是否联通
    private String isAssociateOk(String[] locations){
        try {
            String[] location1 = locations[0].split(",");
            String[] location2 = locations[1].split(",");
            //判断是否是2个坐标
            if (location1.length != 2 || location2.length !=2){
                return "Incorrect command format!";
            }else {
                int[] lo1 = this.transLocation(location1);
                int[] lo2 = this.transLocation(location2);
                //判断实际坐标是否在迷宫内
                if (lo1[0] < 0 || lo1[1] < 0 || lo2[0] < 0 || lo2[1] < 0 || 2 * lo1[0] + 1 > maze.length || 2 * lo1[1] + 1 > maze[0].length || 2 * lo2[0] + 1 > maze.length || 2 * lo2[1] + 1 > maze[0].length){
                    return "Number out of range!";
                }else {
                    int x = lo1[0] - lo2[0];
                    int y = lo1[1] - lo2[1];
                    double distance = Math.sqrt(x * x + y * y);
                    //判断是否联通
                    if (distance != 1){
                        return "Maze format error!";
                    }else {
                        //联通点的实际坐标((2 * lo1[?] + 1) + (2 * lo2[?] + 1))/2
                        int ax = lo1[0] + lo2[0] + 1;
                        int ay = lo1[1] + lo2[1] + 1;
                        //像迷宫中填入实际坐标
                        this.maze[2 * lo1[0] + 1][2 * lo1[1] + 1] = 1;
                        this.maze[2 * lo2[0] + 1][2 * lo2[1] + 1] = 1;
                        this.maze[ax][ay] = 1;
                    }
                }
            }
        }catch (Exception e){
            //强行转换的异常
            return "Invalid number format!";
        }
        return "ok";
    }

    //将字符串坐标转化为数字坐标
    private int[] transLocation(String[] location){
        int[] lo = new int[2];
        lo[0] = Integer.parseInt(location[0].trim());
        lo[1] = Integer.parseInt(location[1].trim());
        return lo;
    }

    //按照格式输出迷宫
    private void printMaze(){
        for (int i = 0; i < this.maze.length; i++) {
            for (int j = 0; j < this.maze[i].length; j++) {
                switch (this.maze[i][j]){
                    case 0:
                        System.out.print("[W]" + "\t");
                        break;
                    case 1:
                        System.out.print("[R]" + "\t");
                        break;
                    case 2:
                        System.out.print("[*]" + "\t");
                        break;
                    default:break;
                }
            }
            System.out.println();
        }
    }

    //判断输入第三行是否输入并返回为标准格式
    private String isRobotIn(String robot){
        //没有输入
        if (robot == null || "".equals(robot) || robot.equals("\n")){
            return "go";
        }else {
            String[] robotIn = robot.trim().split("\\s+");
            if (robotIn.length != 2){
                return "Incorrect command format!";
            }else {
                String[] begin = robotIn[0].split(",");
                try {
                    int[] beginPo = this.transLocation(begin);
                    if (beginPo[0] < 0 || beginPo[1] < 0 || 2 * beginPo[0] + 1 > maze.length || 2 * beginPo[1] + 1 > maze[0].length){
                        //机器人放在了迷宫外面
                        return "Number out of range!";
                    }else if (this.maze[2 * beginPo[0] + 1][2 * beginPo[1] + 1] == 0){
                        //机器人落在了墙上
                        return "go";
                    }else {
                        robotIn[1] = robotIn[1].toUpperCase();
                        return beginPo[0] + "," + beginPo[1] + "," + robotIn[1];
                    }
                }catch (Exception e){
                    //强行转换的异常
                    return "Invalid number format!";
                }
            }
        }
    }

    //机器人的运动 *表示起始位置和最终位置
    private void robotMove(String robotIn){
        String[] robots = robotIn.split(",");
        int x = 2 * Integer.parseInt(robots[0]) + 1;
        int y = 2 * Integer.parseInt(robots[1]) + 1;
        this.maze[x][y] = 2;
        for (int i = 0; i < robots[2].length(); i++){
            switch (robots[2].charAt(i)){
                case 'W':
                    if (this.maze[x - 1][y] == 1){
                        x -= 1;
                    }
                    break;
                case 'A':
                    if (this.maze[x][y - 1] == 1){
                        y -= 1;
                    }
                    break;
                case 'S':
                    if (this.maze[x + 1][y] == 1){
                        x += 1;
                    }
                    break;
                case 'D':
                    if (this.maze[x][y + 1] == 1){
                        y += 1;
                    }
                    break;
                default:break;
            }
        }
        this.maze[x][y] = 2;
    }

    public static void main(String[] args) {
        ThoughtWorks1 mc = new ThoughtWorks1();
        mc.init();
    }
}
