package com.zsx.java8character;

//不重写default
public class ImplementSecond implements SecondInterface{

    @Override
    public void fun() {
        System.out.println("I have implement the Second Interface!");
    }
}
