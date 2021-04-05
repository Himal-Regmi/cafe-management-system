package com.edu.ismt.databaseproject.controller;

import com.edu.ismt.databaseproject.entity.Employee;
import com.edu.ismt.databaseproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String ShowList(Model model){
        List<Employee> employeeList= employeeService.getAll();
        model.addAttribute("employeeList",employeeList);
        return "employee/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        Employee employee= new Employee();
        model.addAttribute("employee",employee);
        return "employee/save";
    }
    @GetMapping("/update-form")
    public String update(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee",employee);
        return "employee/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") @Valid Employee employee,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "employee/save";
        }else{
            employeeService.save(employee);
            return "redirect:/employee/list";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.delete(id);
        return "redirect:/employee/list";
    }
}
