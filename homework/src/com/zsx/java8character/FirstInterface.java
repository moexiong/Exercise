package com.zsx.java8character;

/**
 * 接口中可以有两种有方法体的方法
 * 1.static
 *      接口被继承时，static修饰的有方法体的方法不会被继承
 *      接口被实现时，static修饰的有方法体的方法与实现类无关，不能被重写
 *      该方法只能被自身调用，通过类名来引用，继承或实现的都不行
 * 2.default
 *      接口被继承时，default修饰的有方法体的方法可以被继承并重写
 *      接口被实现时，default修饰的有方法体的方法可以被实现类重写
 *      该方法可以被继承或实现类引用
 */
public interface FirstInterface {

    //接口中的成员变量默认是public static final
    String STRING = "First Interface";

    static void funStatic(){
        System.out.println(STRING + " : I am the static method!");
    }

    default void funDefault(){
        System.out.println(STRING + " : I am the default method!");
    }

    void fun();
}
