package com.atguigu.generic;

import org.junit.Test;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-19 15:00
 **/
public class GenericTest {

    @Test
    public void test01() {

        /**
         * Plate<Fruit> p=new Plate<Apple>(new Apple());
         * Type mismatch: cannot convert from Plate<Apple> to Plate<Fruit>
         * 编译器的逻辑:苹果 IS-A 水果,装苹果的盘子 NOT-IS-A 装水果的盘子
         * 所以，就算容器里装的东西之间有继承关系，但容器之间是没有继承关系的。所以我们不可以把Plate<Apple>的引用传递给Plate<Fruit>。
         * 为了让泛型用起来更舒服，Sun的大脑袋们就想出了<? extends T>和<? super T>的办法，来让“水果盘子” 和 “苹果盘子”之间发生关系。
         * */

        //总结，里面的元素是Fruit的子类，但是不能写，只能读，并且读出来的必须是Fruit本身或者基类，因为Fruit子类很多，不能明确,但是可以强转
        Plate<? extends Fruit> fruitPlate = new Plate<Apple>(new Apple());
        //不能存入任何元素
        //fruitPlate.set(new Apple());    //Error  编译错误
        //fruitPlate.set(new Fruit());    //Error  编译错误

        //读取出来的东西只能放在Fruit或它的基类里
        Fruit newFruit1 = fruitPlate.get();
        Object newFruit2 = fruitPlate.get();
        Apple newFruit3 = (Apple) fruitPlate.get();  //Error

        /**
         * 原因是编译器只知道容器内是Fruit或者它的派生类，但具体是什么类型不知道。可能是Fruit？可能是Apple？
         * 也可能是Banana，RedApple，GreenApple？编译器在看到后面用Plate<Apple>赋值以后，盘子里没有被标上有“苹果”。
         * 而是标上一个占位符：CAP#1，来表示捕获一个Fruit或Fruit的子类，具体是什么类不知道，代号CAP#1。
         * 然后无论是想往里插入Apple或者Meat或者Fruit编译器都不知道能不能和这个CAP#1匹配，所以就都不允许。
         * 所以通配符<?>和类型参数<T>的区别就在于，对编译器来说所有的T都代表同一种类型。
         * 比如下面这个泛型方法里，三个T都指代同一个类型，要么都是String，要么都是Integer。
         * public <T> List<T> fill(T... t);
         * 但通配符<?>没有这种约束，Plate<?>单纯的就表示：盘子里放了一个东西，是什么我不知道。
         *
         * */
    }

    @Test
    public void test02() {
        Plate<? super Fruit> fruitPlate = new Plate<Fruit>(new Fruit());

        //存入元素正常
        fruitPlate.set(new Apple());
        fruitPlate.set(new Fruit());

        //读取出来的东西只能存放在Object类里
        Object newFruit1 = fruitPlate.get();
        //Fruit newFruit2 = fruitPlate.get();  //Error
        //Apple newFruit3 = fruitPlate.get();  //Error

        //因为下界规定了元素的最小粒度的下限，实际上是放松了容器元素的类型控制。
        // 既然元素是Fruit的基类，那往里存粒度比Fruit小的都可以。但往外读取元素就费劲了，只有所有类的基类Object对象才能装下。
        // 但这样的话，元素的类型信息就全部丢失。

        /**
         * 最后看一下什么是PECS（Producer Extends Consumer Super）原则，已经很好理解了：
         * 频繁往外读取内容的，适合用上界Extends。
         * 经常往里插入的，适合用下界Super。
         * */
    }
}
