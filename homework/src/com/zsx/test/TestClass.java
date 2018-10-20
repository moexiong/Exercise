package com.zsx.test;

/**
 * 外部类只能为public (default) abstract final修饰
 * 内部类任意
 */
public class TestClass implements TestInterface{

    public static void main(String[] args) {
        TestInterface testClass = new TestClass();

        int a = 130;
        Integer b = 130;
        long c = 130;
        Long d = 130L;//必须加L
        Integer e = new Integer(65);
        Integer f = new Integer(65);

        System.out.println(a == b);//true 普通与包装==，包装自动拆箱，比较值
        System.out.println(b.equals(a));//true 普通与包装equals，普通自动装箱，先比较类型，再比较值
        System.out.println(a == c);//true 普通不同类型==，比较值
        System.out.println(b.equals(d));//false 包装不同类型equals，先比较类型，再比较值
        System.out.println(a == d);//true 普通与不同包装==，包装自动拆箱，比较值
        System.out.println(d.equals(a));//false 普通与不同包装equals，普通自动装箱，先比较类型，再比较值
        System.out.println(b == (e + f));//true 包装类遇到运算符会自动拆箱，再比较值
        System.out.println(e == f);//false new出来的是不同的对象
        /**
         * 总结，基本数据类型的比较
         * ==
         *      普通与任意普通：比较值
         *      普通与任意包装：包装自动拆箱后，比较值
         *      包装与同包装：比较地址（Integer在-128---127内比较值）
         *      包装与不同包装：无法比较
         * equals
         *      普通与任意普通：比较值
         *      普通与任意包装：普通自动装箱后，先比较类型，再比较值
         *      包装与同包装：比较值
         *      包装与不同包装：先比较类型，再比较值
         * 运算符
         *      遇到运算符，包装自动拆箱，比较值
         *
         * Integer直接赋值：在-128---127之间，不创建对象，不在区间则创建对象
         * Integer使用new：无论何时都会创建对象
         */
    }


}
