package com.atguigu.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 迭代器模式
 * @author: yangjiang
 * @create: 2020-12-28 17:05
 **/
public class Client {
    public static void main(String[] args) {
        //创建学院
        List<College> collegeList = new ArrayList<College>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        //collegeList.add(infoCollege);
        OutPutImpl outPutImpl = new OutPutImpl(collegeList);
        outPutImpl.printCollege();
    }

}
