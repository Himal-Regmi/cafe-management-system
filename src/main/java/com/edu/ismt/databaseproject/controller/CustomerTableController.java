package com.edu.ismt.databaseproject.controller;

import com.edu.ismt.databaseproject.entity.CustomerTable;
import com.edu.ismt.databaseproject.service.CustomerTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("customer-tables")
public class CustomerTableController {
    @Autowired
    private CustomerTableService customerTableService;

    @GetMapping("/list")
    public String ShowCustomers(Model model){
        List<CustomerTable> customerTableList= customerTableService.getAll();
        model.addAttribute("customerTableList",customerTableList);
        return "customer-tables/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        CustomerTable customerTable= new CustomerTable();
        model.addAttribute("customerTable",customerTable);
        return "customer-tables/save";
    }
    @GetMapping("/update-form")
    public String updateCustomer(@RequestParam("tableId") int id, Model model){
        CustomerTable customerTable = customerTableService.getById(id);
        model.addAttribute("customerTable",customerTable);
        return "customer-tables/save";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customerTable") @Valid CustomerTable customerTable,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "customer-tables/save";
        }else{
            customerTableService.save(customerTable);
            return "redirect:/customer-tables/list";
        }
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("tableId") int id){
        customerTableService.delete(id);
        return "redirect:/customer-tables/list";
    }
}
