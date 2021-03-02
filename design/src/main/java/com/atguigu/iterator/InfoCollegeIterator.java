package com.atguigu.iterator;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-28 17:07
 **/

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {

    List<Department> departmentList;
    int index = -1;


    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() - 1) {
            return false;
        } else {
            index += 1;
            return true;
        }
    }


    @Override
    public Object next() {
        Department department = departmentList.get(index);
        index += 1;
        return department;
    }

    @Override
    public void remove() {
    }

}



