package com.atguigu.flyweight01;

import lombok.Data;

import java.util.HashMap;

/**
 * @description:享元（Flyweight）模式的定义：运用共享技术来有效地支持大量细粒度对象的复用。 它通过共享已经存在的对象来大幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源的利用率。
 * 享元模式的主要优点是：相同对象只要保存一份，这降低了系统中对象的数量，从而降低了系统中细粒度对象给内存带来的压力。
 * <p>
 * 其主要缺点是：
 * 为了使对象可以共享，需要将一些不能共享的状态外部化，这将增加程序的复杂性。
 * 读取享元模式的外部状态会使得运行时间稍微变长。
 * <p>
 * 享元模式的结构与实现
 * 享元模式的定义提出了两个要求，细粒度和共享对象。因为要求细粒度，所以不可避免地会使对象数量多且性质相近，此时我们就将这些对象的信息分为两个部分：内部状态和外部状态。
 * 内部状态指对象共享出来的信息，存储在享元信息内部，并且不回随环境的改变而改变；
 * 外部状态指对象得以依赖的一个标记，随环境的改变而改变，不可共享。
 * <p>
 * 比如，连接池中的连接对象，保存在连接对象中的用户名、密码、连接URL等信息，在创建对象的时候就设置好了，不会随环境的改变而改变，这些为内部状态。而当每个连接要被回收利用时，我们需要将它标记为可用状态，这些为外部状态。
 * <p>
 * 享元模式的本质是缓存共享对象，降低内存消耗。
 * @author: yangjiang
 * @create: 2021-03-12 08:58
 **/
public class FlyweightPattern {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f01 = factory.getFlyweight("a");
        Flyweight f02 = factory.getFlyweight("a");
        Flyweight f03 = factory.getFlyweight("a");
        Flyweight f11 = factory.getFlyweight("b");
        Flyweight f12 = factory.getFlyweight("b");
        f01.operation(new UnsharedConcreteFlyweight("第1次调用a。"));
        f02.operation(new UnsharedConcreteFlyweight("第2次调用a。"));
        f03.operation(new UnsharedConcreteFlyweight("第3次调用a。"));
        f11.operation(new UnsharedConcreteFlyweight("第1次调用b。"));
        f12.operation(new UnsharedConcreteFlyweight("第2次调用b。"));
    }

    //非享元角色,里面包含了非共享的外部状态信息 info；
    @Data
    static class UnsharedConcreteFlyweight {
        private String info;

        UnsharedConcreteFlyweight(String info) {
            this.info = info;
        }
    }

    //抽象享元角色，里面包含了享元方法 operation(UnsharedConcreteFlyweight state)，非享元的外部状态以参数的形式通过该方法传入；
    interface Flyweight {
        void operation(FlyweightPattern.UnsharedConcreteFlyweight state);
    }

    //具体享元角色，包含了关键字 key，它实现了抽象享元接口；
    static class ConcreteFlyweight implements Flyweight {
        private String key;

        ConcreteFlyweight(String key) {
            this.key = key;
            System.out.println("具体享元" + key + "被创建！");
        }

        public void operation(FlyweightPattern.UnsharedConcreteFlyweight outState) {
            System.out.print("具体享元" + key + "被调用，");
            System.out.println("非享元信息是:" + outState.getInfo());
        }
    }

    //享元工厂角色,它是关键字 key 来管理具体享元；
    static class FlyweightFactory {
        private HashMap<String, Flyweight> flyweights = new HashMap<>();

        public Flyweight getFlyweight(String key) {
            Flyweight flyweight = flyweights.get(key);
            if (flyweight != null) {
                System.out.println("具体享元" + key + "已经存在，被成功获取！");
            } else {
                flyweight = new ConcreteFlyweight(key);
                flyweights.put(key, flyweight);
            }
            return flyweight;
        }
    }
}
