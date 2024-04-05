package com.dao;

import com.pojo.Department;
import com.pojo.Employee;
import com.pojo.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
//    模拟数据库的数据
    private static Map<Integer, Employee> employeeMap = null;
//    员工有所属的部门
    @Resource
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(1001, new Employee(1001, "AA", "1797719651@qq.com", 1, new Department(101, "教学部")));
        employeeMap.put(1002, new Employee(1002, "BB", "2797719651@qq.com", 0, new Department(102, "音乐部")));
        employeeMap.put(1003, new Employee(1003, "CC", "3797719651@qq.com", 0, new Department(103, "信息部")));
        employeeMap.put(1004, new Employee(1004, "DD", "4797719651@qq.com", 1, new Department(104, "AI部")));
    }

//    主键
    private static Integer initId = 1006;
//    增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentByID(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }
//    查询全部员工信息
    public Collection<Employee> getAll() {
        return employeeMap.values();
    }

//    通过id查询员工
    public Employee getEmployeeByID(Integer id) {
        return employeeMap.get(id);
    }

//    删除员工通过id
    public void deleteEmployeeByID(Integer id) {
        employeeMap.remove(id);
    }
}
