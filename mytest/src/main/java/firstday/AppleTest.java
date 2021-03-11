package firstday;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: yangjiang
 * @create: 2021-03-11 15:10
 **/
public class AppleTest {

    public static void main(String[] args) {

    }



    //分组：List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起：
    @Test
    public void test01(){
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
        Map<Integer, List<Apple>> collect = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println(collect);
    }
}
