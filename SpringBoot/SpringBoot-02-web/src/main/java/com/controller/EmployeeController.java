package com.controller;

import com.dao.DepartmentDao;
import com.dao.EmployeeDao;
import com.pojo.Department;
import com.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("emp")
    public String toAddPage(Model model) {
//      查出所有的部门信息
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String AddEmp(Employee employee) {
        System.out.println("save" + employee);
        employeeDao.save(employee);
        System.out.println(employee.getDate());
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
//      查出原来的数据
        Employee employee = employeeDao.getEmployeeByID(id);
        model.addAttribute("emp", employee);
        //  查出所有的部门信息
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

//    删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeDao.deleteEmployeeByID(id);
        return "redirect:/emps";
    }

}
