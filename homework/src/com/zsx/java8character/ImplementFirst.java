package com.zsx.java8character;

//重写default
public class ImplementFirst implements FirstInterface{

    @Override
    public void funDefault() {
        System.out.println("I have implement the First Interface!");
    }

    @Override
    public void fun() {
        System.out.println("I have implement the First Interface!");
    }
}
