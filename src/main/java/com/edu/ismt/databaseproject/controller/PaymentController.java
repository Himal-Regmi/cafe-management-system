package com.edu.ismt.databaseproject.controller;

import com.edu.ismt.databaseproject.entity.Payment;
import com.edu.ismt.databaseproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/list")
    public String ShowList(Model model){
        List<Payment> paymentList= paymentService.getAll();
        model.addAttribute("paymentList",paymentList);
        return "payment/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        Payment payment=new Payment();
        model.addAttribute("payment",payment);
        return "payment/save";
    }
    @GetMapping("/update-form")
    public String update(@RequestParam("paymentId") int id, Model model){
        Payment payment= paymentService.getById(id);
        model.addAttribute("payment",payment);
        return "payment/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("payment") @Valid Payment payment,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "payment/save";
        }else{
            paymentService.save(payment);
            return "redirect:/payment/list";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("paymentId") int id){
        paymentService.delete(id);
        return "redirect:/payment/list";
    }
}
