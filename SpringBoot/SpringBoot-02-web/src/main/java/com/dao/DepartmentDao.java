package com.dao;

import com.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {
//    模拟数据库中的数据库
    private static Map<Integer, Department> departmentMap = null;
//    员工有所属的部门

    static {
        departmentMap = new HashMap<Integer, Department>();
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "音乐部"));
        departmentMap.put(103, new Department(103, "信息部"));
        departmentMap.put(104, new Department(104, "AI部"));
    }

//    获取所有部门的信息
    public Collection<Department> getDepartment() {
        return departmentMap.values();
    }

//    通过id得到部门
    public Department getDepartmentByID(Integer id) {
        return departmentMap.get(id);
    }

}
