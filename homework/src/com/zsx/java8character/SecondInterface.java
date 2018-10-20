package com.zsx.java8character;

/**
 * 继承第一个接口
 */
public interface SecondInterface extends FirstInterface{

    String STRING = "Second Interface";

    //无法重写第一个接口的static方法
    static void funStatic(){
        System.out.println(STRING + " : I am the static method!");
    }

    //可以重写第一个接口的default方法
    @Override
    default void funDefault(){
        System.out.println(STRING + " : I am the default method!");
    }

    //普通方法可以被重写?有用么，又没有方法体
    @Override
    void fun();
}
