package com.atguigu.iterator;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-28 17:07
 **/

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {


    List<Department> departmentList; //  信息工程学院是以 List 方式存放系
    int index = -1;//索引


    public InfoColleageIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    //判断 list 中还有没有下一个元素
    @Override
    public boolean hasNext() {
        return false;


    }


    @Override
    public Object next() {

    }

    // 空 实 现 remove public void remove() {


}



