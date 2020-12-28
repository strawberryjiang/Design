package com.atguigu.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-28 17:08
 **/
public class InfoCollege implements College {

    List<Department> departmentList;

    public InfoCollege() {
        departmentList = new ArrayList<Department>();
        addDepartment("信息安全专业", " 信息安全专业 "); addDepartment("网络安全专业", " 网络安全专业 ");
        addDepartment("服务器安全专业", "  服务器安全专业 ");
    }

    @Override
    public String getName() {
        return  null;
    }


    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc); departmentList.add(department);
    }


    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }


}
