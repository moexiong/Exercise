package com.zsx.java8character;

public class Main {

    public static void main(String[] args){
        FirstInterface firstInterface = new ImplementFirst();
        //无法调用static方法
        //无法调用STRING常量
        firstInterface.fun();
        //重写的
        firstInterface.funDefault();

        SecondInterface secondInterface = new ImplementSecond();
        secondInterface.fun();
        //没有重写的
        secondInterface.funDefault();

        //通过自身调用
        FirstInterface.funStatic();
        System.out.println(FirstInterface.STRING);
    }

}
