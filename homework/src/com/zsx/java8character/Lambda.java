package com.zsx.java8character;

/**
 * 基本语法：
 *     <函数式接口>  <变量名> = (参数1，参数2...) -> {
 *          方法体
 *     }
 *
 * 引用实例方法：
 *     <函数式接口>  <变量名> = <实例>::<实例方法名>
 *     调用：
 *     <变量名>.接口方法([实际参数...])
 *
 * 引用类方法：
 *     <函数式接口>  <变量名> = <类>::<类方法名称>
 *     调用：
 *     <变量名>.接口方法([实际参数...])
 *
 * 引用类的实例方法：
 *     定义接口
 *     interface <函数式接口>{
 *         <返回值> <方法名>(<类><类名称>,[其他参数...]);
 *     }
 *     <函数式接口>  <变量名> = <类>::<类实例方法名>
 *     调用：
 *     <变量名>.接口方法(类的实例,[实际参数...])
 *
 * 引用构造器方法：
 *     <函数式接口>  <变量名> = <类>::<new>
 *     调用：
 *     <变量名>.接口方法([实际参数...])
 */
public class Lambda {

    //无参，无返回值
    private interface NoReturn{
        void foo();
    }

    //无参，有返回值
    private interface AReturn{
        int foo();
    }

    //有参，无返回值
    private interface NoReturnParam{
        void foo(int a);
    }

    //有参，有返回值
    private interface AReturnParam{
        int foo(int a);
    }

    public static void main(String[] args){
        //无参，无返回值
        //旧的实现方式，此处显示的为实现接口中方法
        NoReturn noReturn = new NoReturn() {
            @Override
            public void foo() {
                System.out.println("hello old");
            }
        };
        noReturn.foo();
        //Lambda表达式，此处显示的为重写接口中的方法
        NoReturn noReturn1 = () -> System.out.println("hello lambda");
        noReturn1.foo();

        //无参，有返回值
        int y = 0;
        AReturn aReturn = () -> {
            System.out.println("the y will be final:" + y);
            return y + 10;
        };
        System.out.println(aReturn.foo());

        //有参，无返回值
        NoReturnParam NoReturnParam = (a) -> System.out.println(a);
        NoReturnParam NoReturnParam1 = b -> System.out.println(b);
        NoReturnParam.foo(1);
        NoReturnParam1.foo(2);
        //上面2中方式的更简单表达
        NoReturnParam NoReturnParam3 = System.out::println;
        NoReturnParam3.foo(3);

        //有参，有返回值
        AReturnParam aReturnParam = a -> {
            System.out.println(a);
            return a % 10;
        };
        System.out.println(aReturnParam.foo(66));
    }
}
