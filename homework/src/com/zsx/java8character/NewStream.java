package com.zsx.java8character;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Predicate 接口
 *      Predicate 接口只有一个参数，返回boolean类型。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）
 *
 * Function 接口
 *      Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）
 *
 * Consumer 接口
 *      Consumer 接口表示执行在单个参数上的操作。接口只有一个参数，且无返回值
 *
 * Comparator 接口
 *      Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法
 *
 * Supplier 接口
 *      Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
 *
 * Optional 接口
 *      Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型，这是下一届中将要用到的重要概念，现在先简单的看看这个接口能干什么：
 *      Optional 被定义为一个简单的容器，其值可能是null或者不是null。在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，而在Java 8中，不推荐你返回null而是返回Optional。
 *
 * Stream 接口
 *      如下：
 */
public class NewStream {

    private static void createStream(){
        //通过Stream.of来创建
        Stream<Integer> integerStream = Stream.of(1,2,4,8);
        Stream<String> stringStream = Stream.of("hello");

        //通过Stream.generate来创建,创建的是无限长度的Stream,三种一样，写法不同
        //由于生成的长度无限，所以采用的懒加载，并且一般与limit配合使用,如第3个
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });
        Stream<Double> doubleStream1 = Stream.generate(() -> Math.random());
        Stream<Double> doubleStream2 = Stream.generate(Math::random).limit(10);

        //通过Stream.iterate来创建，也是生成无限长度的Stream，其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的
        //也要配合limit使用，取出前10个数字打印
        Stream.iterate(46, i -> i + 1).limit(10).forEach(System.out::println);

        //Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set， Map不支持。Stream的操作可以串行执行或者并行执行。
        //Java 8扩展了集合类，可以通过 Collection.stream() 或者 Collection.parallelStream() 来创建一个Stream。
        //Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
        int max = 1000000;
        List<String> list = new ArrayList<>(max);
        for (int i = 0; i < max; i++){
            list.add(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        //串行排序
        long t0 = System.nanoTime();
        long count = list.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
        //并行排序
        long t2 = System.nanoTime();
        long count1 = list.parallelStream().sorted().count();
        System.out.println(count1);
        long t3 = System.nanoTime();
        long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millis1));

        //长度为18，大于50的有8个数
        List<Integer> integerList = Arrays.asList(8, 25, 91, 35, 74, 0, 27, 36, 95, 59, 19, 22, 4, 25, 59, 84, 82, 66);
        //count方法，统计stream的长度
        System.out.println("count:" + integerList.parallelStream().count());

        //max方法，获取最大值，调用Comparator接口
        System.out.println("max:" + integerList.parallelStream().max(Comparator.comparingInt(a -> a)).get());

        //min方法，获取最小值，调用Comparator接口
        System.out.println("min:" + integerList.parallelStream().min(Comparator.comparingInt(a -> a)).get());

        //filter方法，通过一个predicate接口来过滤并只保留符合条件的元素，中间操作
        System.out.println("count filter > 50:" + integerList.stream().filter(Objects::nonNull).filter(num -> num > 50).count());

        //distinct方法，去除stream中的重复元素，中间操作
        integerList.stream().distinct().forEach(System.out::println);
        System.out.println("after distinct：" + integerList.toString());

        //sorted方法，排序stream，可以使用filter，中间操作
        //需要注意的是，排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据integerList是不会被修改的
        integerList.stream().sorted().filter(num -> num > 10).forEach(System.out::println);
        System.out.println("after sorted：" + integerList.toString());

        //map方法，根据筛选创建一个新的stream
        //自带mapToInt，mapToLong，mapToDouble方法
        List<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("312");
        strings.add("231");
        strings.stream().mapToInt(Integer::valueOf).forEach(System.out::println);
        strings.stream().mapToInt(Integer::parseInt).forEach(System.out::println);

        //limit方法，对一个Stream进行截断操作，获取其前N个元素，如果原Stream中包含的元素个数小于N，那就获取其所有的元素，中间操作
        //skip方法，返回一个丢弃原Stream的前N个元素后剩下元素组成的新Stream，如果原Stream中包含的元素个数小于N，那么返回空Stream，中间操作
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(null);
        numbers.add(5);
        numbers.add(5);
        numbers.add(9);
        numbers.add(11);
        System.out.println("sum is:" + numbers.stream().filter(Objects::nonNull).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());
        System.out.println("after limit or skip：" + numbers.toString());

        //match匹配，Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。返回一个boolean类型的值，所有的匹配操作都是最终操作
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add("i");
        stringList.add("need");
        stringList.add("to");
        stringList.add("improve");
        boolean isMatch = stringList.stream().allMatch(s -> s.startsWith("i"));
        System.out.println("allMatch:" + isMatch);
        System.out.println("anyMatch:" + stringList.stream().anyMatch(s -> s.startsWith("i")));
        System.out.println("noneMatch:" + stringList.stream().noneMatch(s -> s.length() > 9));

        //Reduce 规约，允许通过指定的函数来讲stream中的多个元素规约为一个元素，规越后的结果是通过Optional接口表示的，最终操作
        Optional<String> optional = stringList.stream().reduce((s1, s2) -> s1 + s2);
        optional.ifPresent(System.out::println);
    }

    public static void main(String[] args){
        createStream();
    }
}
